package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.dto.PartidaDTO;
import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.Pregunta;
import co.edu.unbosque.geoquest.entity.Usuario;
import co.edu.unbosque.geoquest.entity.Partida.EstadoPartida;
import co.edu.unbosque.geoquest.repository.CategoriaRepository;
import co.edu.unbosque.geoquest.repository.PartidaRepository;
import co.edu.unbosque.geoquest.repository.RespuestaRepository;

/**
 * Servicio que proporciona operaciones CRUD y funcionalidades adicionales para
 * partidas. Implementa la interfaz CRUDOperation para operaciones básicas de
 * creación, lectura, actualización y eliminación.
 */
@Service
public class PartidaService implements CRUDOperation<PartidaDTO> {

	@Autowired
	private PartidaRepository partidaRepo;
	@Autowired
	private RespuestaRepository respuestaRepo;
	@Autowired
	private CategoriaRepository categoriaRepo;
	@Autowired
	private PreguntaService preguntaSer;
	@Autowired
	private UsuarioService usuarioSer;
	@Autowired
	private ModelMapper modelMapper;

	public PartidaService() {
		// TODO Auto-generated constructor stub
	}

	public PartidaDTO iniciarDificultad(int dificultad, String nombreUsuario) {
		Partida partida = new Partida();
		Usuario usuario = modelMapper.map(usuarioSer.obtenerPorNombre(nombreUsuario), Usuario.class);
		partida.setUsuario(usuario);
		partida.setNivelDificultad(dificultad);
		partida.setEstado(EstadoPartida.EN_CURSO);

		partida = partidaRepo.save(partida);

		List<Pregunta> preguntas = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			preguntas.add(preguntaSer.generarPreguntaDificultad(dificultad, partida));
		}

		partida.setPreguntas(preguntas);

		partidaRepo.save(partida);
		return modelMapper.map(partida, PartidaDTO.class);

	}

	public PartidaDTO iniciarCategoria(Long categoria, String nombreUsuario) {
		Partida partida = new Partida();
		Usuario usuario = modelMapper.map(usuarioSer.obtenerPorNombre(nombreUsuario), Usuario.class);
		partida.setUsuario(usuario);
		partida.setEstado(EstadoPartida.EN_CURSO);
		partida = partidaRepo.save(partida);
		List<Pregunta> preguntas = new ArrayList<>();
		if (categoria == 8) {
			for (int i = 0; i < 10; i++) {
				preguntas.add(preguntaSer.generarPreguntaRandom(partida));
			}
		} else {
			partida.setCategoria(categoriaRepo.getById(categoria));;
			for (int i = 0; i < 10; i++) {
				preguntas.add(preguntaSer.generarPreguntaCategoria(categoria, partida));
			}
		}

		partida.setPreguntas(preguntas);
		partidaRepo.save(partida);
		return modelMapper.map(partida, PartidaDTO.class);

	}

	public int updatePartida(Long id, int respuestasCorrectas, int puntos) {
		Optional<Partida> found = partidaRepo.findById(id);
		if (found.isPresent()) {
			Partida temp = found.get();
			temp.setEstado(EstadoPartida.FINALIZADA);
			temp.setRespuestasCorrectas(respuestasCorrectas);
			temp.setPuntosTotales(puntos);
			usuarioSer.setPuntos(puntos, temp.getUsuario().getIdUsuario());
			partidaRepo.save(temp);
			respuestaRepo.borrarIncorrectasPorPartida(id);
			return 1;
		}
		if (!found.isPresent()) {
			return 2;
		} else {
			return 3;
		}

	}

	@Override
	public int create(PartidaDTO data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PartidaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Long id, PartidaDTO newData) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}