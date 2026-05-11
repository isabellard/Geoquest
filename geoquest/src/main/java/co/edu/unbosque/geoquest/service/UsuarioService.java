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
import co.edu.unbosque.geoquest.entity.Usuario;
import co.edu.unbosque.geoquest.repository.UsuarioRepository;

@Service
public class UsuarioService implements CRUDOperation<UsuarioDTO> {

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UsuarioService() {

	}

	@Override
	public long count() {
		return userRepo.count();
	}

	@Override
	public boolean exist(Long id) {
		return userRepo.existsById(id) ? true : false;
	}

	@Override
	public int create(UsuarioDTO data) {
		Usuario entity = modelMapper.map(data, Usuario.class);
		if (findUsernameAlreadyTaken(entity)) {
			return 1;
		} else {
			// Hash the password before saving
			entity.setPassword(passwordEncoder.encode(entity.getPassword()));
			userRepo.save(entity);
			return 0;
		}
	}

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

	public int deleteByUsername(String username) {
		Optional<Usuario> found = userRepo.findByUsuario(username);
		if (found.isPresent()) {
			userRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int updateById(Long id, UsuarioDTO newData) {
		Optional<Usuario> found = userRepo.findById(id);
		Optional<Usuario> newFound = userRepo.findByUsuario(newData.getUsername());

		if (found.isPresent() && !newFound.isPresent()) {
			Usuario temp = found.get();
			temp.setUsuario(newData.getUsername());
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

	public UsuarioDTO getById(Long id) {
		Optional<Usuario> found = userRepo.findById(id);
		if (found.isPresent()) {
			return modelMapper.map(found.get(), UsuarioDTO.class);
		} else {
			return null;
		}
	}

	public boolean findUsernameAlreadyTaken(Usuario newUser) {
		Optional<Usuario> found = userRepo.findByUsuario(newUser.getUsername());
		if (found.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean findUsernameAlreadyTaken(String username) {
		Optional<Usuario> found = userRepo.findByUsuario(username);
		return found.isPresent();
	}

	public int validateCredentials(String username, String password) {
		// Find user by username
		Optional<Usuario> userOpt = userRepo.findByUsuario(username);

		// Check if user exists and password matches
		if (userOpt.isPresent()) {
			Usuario user = userOpt.get();
			if (passwordEncoder.matches(password, user.getPassword())) {
				return 0; // Success
			}
		}

		return 1; // Invalid credentials
	}
	
	  public UsuarioDTO obtenerPorNombre(String nombreUsuario) {
	        Usuario usuario = userRepo.findByUsuario(nombreUsuario)
	                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));
	        return modelMapper.map(usuario, UsuarioDTO.class);
	    }

}
