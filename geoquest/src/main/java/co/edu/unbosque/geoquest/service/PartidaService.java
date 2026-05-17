package co.edu.unbosque.geoquest.service;

import java.time.LocalDateTime;
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
import co.edu.unbosque.geoquest.repository.UsuarioRepository;

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
	private UsuarioRepository usuarioRepo;
	@Autowired
	private LogroService logroSer; 
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
		Usuario usuario = usuarioRepo.getReferenceById(usuarioSer.obtenerIdPorNombre(nombreUsuario));
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
		long t0 = System.currentTimeMillis();

		Partida partida = new Partida();
		Usuario usuario = usuarioRepo.getReferenceById(usuarioSer.obtenerIdPorNombre(nombreUsuario));
		partida.setUsuario(usuario);
		partida.setEstado(EstadoPartida.EN_CURSO);

		long t1 = System.currentTimeMillis();
		System.out.println(">> Usuario obtenido: " + (t1 - t0) + "ms");

		partida = partidaRepo.save(partida);

		long t2 = System.currentTimeMillis();
		System.out.println(">> Partida guardada: " + (t2 - t1) + "ms");

		List<Pregunta> preguntas = new ArrayList<>();
		if (categoria == 8) {
			for (int i = 0; i < 10; i++) {
				long tp = System.currentTimeMillis();
				preguntas.add(preguntaSer.generarPreguntaRandom(partida));
				System.out.println(">> Pregunta " + (i + 1) + ": " + (System.currentTimeMillis() - tp) + "ms");

			}
		} else {

			partida.setCategoria(categoriaRepo.getById(categoria));
			;

			for (int i = 0; i < 10; i++) {
				long tp = System.currentTimeMillis();
				preguntas.add(preguntaSer.generarPreguntaCategoria(categoria, partida));
				System.out.println(">> Pregunta " + (i + 1) + ": " + (System.currentTimeMillis() - tp) + "ms");

			}
		}
		long t3 = System.currentTimeMillis();
		System.out.println(">> 10 preguntas generadas: " + (t3 - t2) + "ms");

		partida.setPreguntas(preguntas);

		partidaRepo.save(partida);
		long t4 = System.currentTimeMillis();
		System.out.println(">> Save final: " + (t4 - t3) + "ms");
		long t5 = System.currentTimeMillis();
	    System.out.println(">> TOTAL: " + (t5 - t0) + "ms");
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
			logroSer.verificarLogros(temp.getUsuario());
			return 1;
		}
		if (!found.isPresent()) {
			return 2;
		} else {
			return 3;
		}

	}

	public int actualizarPartidasAbandonadas() {
		LocalDateTime haceUnDia = LocalDateTime.now().minusDays(1);

		List<Partida> partidasAntiguas = partidaRepo.findByEstadoAndFechaBefore(EstadoPartida.EN_CURSO, haceUnDia);

		if (partidasAntiguas.isEmpty()) {
			return 0;
		} else {
			for (Partida partida : partidasAntiguas) {
				partida.setEstado(EstadoPartida.ABANDONADA);
			}
			partidaRepo.saveAll(partidasAntiguas);
			System.out.println("Partidas abandonadas actualizadas: " + partidasAntiguas.size());
			return 1;
		}

	}

	@Override
	public int create(PartidaDTO data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PartidaDTO> getAll() {
		List<Partida> entityList = partidaRepo.findAll();
		List<PartidaDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {

			PartidaDTO dto = modelMapper.map(entity, PartidaDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
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