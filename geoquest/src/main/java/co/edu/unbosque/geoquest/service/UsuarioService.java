package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import co.edu.unbosque.geoquest.dto.UsuarioDTO;

import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.Usuario;
import co.edu.unbosque.geoquest.entity.Usuario.Role;
import co.edu.unbosque.geoquest.repository.PartidaRepository;
import co.edu.unbosque.geoquest.repository.UsuarioRepository;

/**
 * Servicio que proporciona operaciones CRUD y funcionalidades adicionales para
 * usuarios. Implementa la interfaz CRUDOperation para operaciones básicas de
 * creación, lectura, actualización y eliminación.
 */
@Service
public class UsuarioService implements CRUDOperation<UsuarioDTO> {

	/** Repositorio para acceder a los datos de usuarios en la base de datos. */
	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private PartidaRepository partidaRepo;

	/** Mapeador para convertir entre entidades User y DTOs UserDTO. */
	@Autowired
	private ModelMapper modelMapper;

	/** Constructor por defecto. */
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioService() {

	}

	/**
	 * Cuenta el número total de usuarios en la base de datos.
	 *
	 * @return Número total de usuarios
	 */
	@Override
	public long count() {
		return userRepo.count();
	}

	/**
	 * Verifica si existe un usuario con el ID especificado.
	 *
	 * @param id ID del usuario a verificar
	 * @return true si el usuario existe, false en caso contrario
	 */
	@Override
	public boolean exist(Long id) {
		return userRepo.existsById(id) ? true : false;
	}

	/**
	 * Crea un nuevo usuario en la base de datos. Codifica la contraseña antes de
	 * guardarla.
	 *
	 * @param data DTO con los datos del usuario a crear
	 * @return 0 si la creación fue exitosa, 1 si el nombre de usuario ya existe
	 */
	@Override
	public int create(UsuarioDTO data) {
		Usuario entity = modelMapper.map(data, Usuario.class);
		if (findUsernameAlreadyTaken(entity)) {
			return 1;
		} else {
			// Hash the password before saving
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
			if (entity.getRole() == null) {
				entity.setRole(Role.USER);
			}

			userRepo.save(entity);
			return 0;
		}
	}

	/**
	 * Obtiene todos los usuarios de la base de datos.
	 *
	 * @return Lista de DTOs de usuarios
	 */
	@Override
	public List<UsuarioDTO> getAll() {
		List<Usuario> entityList = userRepo.findAll();
		List<UsuarioDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {

			UsuarioDTO dto = modelMapper.map(entity, UsuarioDTO.class);
			dtoList.add(dto);
		});

		return dtoList;
	}

	/**
	 * Elimina un usuario por su ID.
	 *
	 * @param id ID del usuario a eliminar
	 * @return 0 si la eliminación fue exitosa, 1 si el usuario no existe
	 */
	@Override
	public int deleteById(Long id) {
		Optional<Usuario> found = userRepo.findById(id);
		if (found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Elimina un usuario por su nombre de usuario.
	 *
	 * @param username Nombre de usuario del usuario a eliminar
	 * @return 0 si la eliminación fue exitosa, 1 si el usuario no existe
	 */
	public int deleteByUsername(String username) {
		Optional<Usuario> found = userRepo.findBynombreUsuario(username);
		if (found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Actualiza un usuario existente por su ID. Codifica la contraseña antes de
	 * guardarla.
	 *
	 * @param id      ID del usuario a actualizar
	 * @param newData DTO con los nuevos datos del usuario
	 * @return 0 si la actualización fue exitosa, 1 si el nuevo nombre de usuario ya
	 *         está en uso, 2 si el usuario a actualizar no existe, 3 en otros casos
	 *         de error
	 */
	@Override
	public int updateById(Long id, UsuarioDTO newData) {
		Optional<Usuario> found = userRepo.findById(id);
		Optional<Usuario> newFound = userRepo.findBynombreUsuario(newData.getNombreUsuario());

		if (found.isPresent() && !newFound.isPresent()) {
			Usuario temp = found.get();
			temp.setNombreUsuario(newData.getNombreUsuario());
			// Hash the password before saving
			temp.setPassword(passwordEncoder.encode(newData.getPassword()));
			userRepo.save(temp);
			return 0;
		}
		if (found.isPresent() && newFound.isPresent()) {
			return 1;
		}
		if (!found.isPresent()) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * Obtiene un usuario por su ID.
	 *
	 * @param id ID del usuario a obtener
	 * @return DTO del usuario si existe, null en caso contrario
	 */
	public UsuarioDTO getById(Long id) {
		Optional<Usuario> found = userRepo.findById(id);
		if (found.isPresent()) {
			return modelMapper.map(found.get(), UsuarioDTO.class);
		} else {
			return null;
		}
	}

	/**
	 * Verifica si un nombre de usuario ya está en uso.
	 *
	 * @param newUser Usuario con el nombre de usuario a verificar
	 * @return true si el nombre de usuario ya está en uso, false en caso contrario
	 */
	public boolean findUsernameAlreadyTaken(Usuario newUser) {
		Optional<Usuario> found = userRepo.findBynombreUsuario(newUser.getUsername());
		if (found.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica si un nombre de usuario ya está en uso.
	 *
	 * @param username Nombre de usuario a verificar
	 * @return true si el nombre de usuario ya está en uso, false en caso contrario
	 */
	public boolean findUsernameAlreadyTaken(String username) {
		Optional<Usuario> found = userRepo.findBynombreUsuario(username);
		return found.isPresent();
	}

	/**
	 * Valida las credenciales de un usuario.
	 *
	 * @param username Nombre de usuario
	 * @param password Contraseña sin encriptar
	 * @return 0 si las credenciales son válidas, 1 si son inválidas
	 */
	public int validateCredentials(String username, String password) {
		// Find Usuario by username
		Optional<Usuario> userOpt = userRepo.findBynombreUsuario(username);

		// Check if Usuario exists and password matches
		if (userOpt.isPresent()) {
			Usuario Usuario = userOpt.get();
			if (passwordEncoder.matches(password, Usuario.getPassword())) {
				return 0; // Success
			}
		}

		return 1; // Invalid credentials
	}

	public UsuarioDTO obtenerPorNombre(String nombreUsuario) {
		Usuario usuario = userRepo.findBynombreUsuario(nombreUsuario)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	public boolean verificarUsuarioPorToken(int token) {
		Optional<Usuario> userOpt = userRepo.findByToken(token);

		if (userOpt.isPresent()) {
			Usuario user = userOpt.get();
			user.setVerificado(true);
			user.setToken(0);
			userRepo.save(user);
			return true;
		}
		return false;
	}

	public int getRankingByUsername(String username) {
		List<Usuario> ranking = userRepo.findTopByPuntos();
		for (int i = 0; i < ranking.size(); i++) {
			if (ranking.get(i).getNombreUsuario().equals(username)) {
				return i + 1;
			}
		}
		return -1;
	}

	public int getLogrosByUsername(String username) {
		Usuario user = userRepo.findBynombreUsuario(username).get();
		return user.getLogros().size();

	}

	public int preguntasCorrectas(String username) {
		Usuario user = userRepo.findBynombreUsuario(username).get();
		List<Partida> partidas = partidaRepo.findByUsuario(user);
		int contador = 0;
		for (Partida partida : partidas) {
			contador += partida.getRespuestasCorrectas();
		}
		return contador;
	}

	public int partidaJugadas(String username) {
		UsuarioDTO user = obtenerPorNombre(username);
		return user.getPartidas().size();
	}
	
	public Long obtenerIdPorNombre(String nombre) {
	    return userRepo.findBynombreUsuario(nombre).get().getIdUsuario();
	}

	public void setPuntos(int puntos, Long id) {
		Optional<Usuario> found = userRepo.findById(id);
		Usuario temp = found.get();
		int puntosTotales = temp.getPuntosTotales() + puntos;
		temp.setPuntosTotales(puntosTotales);
		userRepo.save(temp);
	}
}
