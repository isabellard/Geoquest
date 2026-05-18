package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.dto.LogroDTO;
import co.edu.unbosque.geoquest.entity.Auditoria.TipoAccion;
import co.edu.unbosque.geoquest.entity.Logro;
import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.Partida.EstadoPartida;
import co.edu.unbosque.geoquest.entity.Usuario;
import co.edu.unbosque.geoquest.repository.LogroRepository;
import co.edu.unbosque.geoquest.repository.PartidaRepository;
import co.edu.unbosque.geoquest.repository.UsuarioRepository;

@Service
public class LogroService {

	@Autowired
	private LogroRepository logroRepo;
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private PartidaRepository partidaRepo;

	@Autowired
	private AuditoriaService auditoriaService;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsuarioService userSer;

	public LogroService() {
		// TODO Auto-generated constructor stub
	}

	public void verificarLogros(Usuario usuario) {
		List<Logro> todosLogros = logroRepo.findAll();
		List<Logro> logrosUsuario = usuario.getLogros();
		List<Long> idsDesbloqueados = logrosUsuario.stream().map(Logro::getIdLogro).toList();

		int contador = 0;
		int partidasJugadas = (int) partidaRepo.countByUsuarioAndEstado(usuario, EstadoPartida.FINALIZADA);
		System.out.println(partidasJugadas);
		int puntosTotales = usuario.getPuntosTotales();
		System.out.println(puntosTotales);
		int rankingPos = userSer.getRankingByUsername(usuario.getUsername());
		int preguntasCorrectas = partidaRepo.findByUsuario(usuario).getLast().getRespuestasCorrectas();
		int categoriasJugadas = (int) contarCategoriasUnicas(usuario);
		System.out.println(rankingPos);

		for (Logro logro : todosLogros) {
			if (idsDesbloqueados.contains(logro.getIdLogro()))
				continue;
			boolean desbloquear = switch (logro.getTipo()) {
			case PRIMERA_VICTORIA -> partidasJugadas >= 1;
			case PARTIDAS_JUGADAS -> (logro.getDescripcion().equals("Explorer") && partidasJugadas >= 10)
					|| (logro.getDescripcion().equals("Veteran") && partidasJugadas >= 50);
			case PUNTOS_TOTALES -> (logro.getDescripcion().equals("Collector") && puntosTotales >= 1000)
					|| (logro.getDescripcion().equals("Millionaire") && puntosTotales >= 5000);
			case RANKING -> (logro.getDescripcion().equals("Top 1") && rankingPos >= 1
					|| logro.getDescripcion().equals("Top 3") && rankingPos >= 3
					|| logro.getDescripcion().equals("Top 10") && rankingPos >= 10)
					|| (logro.getDescripcion().equals("Millionaire") && puntosTotales >= 5000);
			case RESPUESTAS_CORRECTAS -> (logro.getDescripcion().equals("On a Streak") && preguntasCorrectas >= 5)
					|| (logro.getDescripcion().equals("Unstoppable") && preguntasCorrectas >= 7)
					|| (logro.getDescripcion().equals("Perfect!") && preguntasCorrectas >= 10);

			case CATEGORIAS_DESCUBIERTAS -> (logro.getDescripcion().equals("Curious") && categoriasJugadas >= 3)
					|| (logro.getDescripcion().equals("World Traveler") && categoriasJugadas >= 7);

			case MASTER_CATEGORIA ->
				(logro.getDescripcion().equals("Flags Master") && findByCategoriaIdAndUsuario(usuario, 2)
						|| logro.getDescripcion().equals("Calling Codes Master")
								&& findByCategoriaIdAndUsuario(usuario, 4)
						|| logro.getDescripcion().equals("Capitals Master") && findByCategoriaIdAndUsuario(usuario, 1)
						|| logro.getDescripcion().equals("Continents Master") && findByCategoriaIdAndUsuario(usuario, 6)
						|| logro.getDescripcion().equals("Currencies Master") && findByCategoriaIdAndUsuario(usuario, 5)
						|| logro.getDescripcion().equals("Languages Master") && findByCategoriaIdAndUsuario(usuario, 3)
						|| logro.getDescripcion().equals("Population Master")
								&& findByCategoriaIdAndUsuario(usuario, 7));

			default -> false;
			};

			if (desbloquear) {
				logrosUsuario.add(logro);
				usuario.setPuntosTotales(puntosTotales + logro.getPuntosRecompensa());
				auditoriaService.registrar(usuario.getNombreUsuario(), TipoAccion.LOGRO,
						"Unlocked: " + logro.getDescripcion());
			}
		}

		usuario.setLogros(logrosUsuario);
		usuarioRepo.save(usuario);
	}

	public List<LogroDTO> getLogrosConEstado(String username) {
		Usuario usuario = usuarioRepo.findBynombreUsuario(username).get();
		List<Logro> logrosUsuario = usuario.getLogros();

		List<LogroDTO> resultado = new ArrayList<>();
		for (Logro logro : logrosUsuario) {
			resultado.add(modelMapper.map(logro, LogroDTO.class));
		}
		return resultado;
	}

	public boolean findByCategoriaIdAndUsuario(Usuario user, long categoria) {
		List<Partida> listaPartidas = partidaRepo.findByUsuarioAndEstado(user, EstadoPartida.FINALIZADA);
		for (Partida partida : listaPartidas) {
			if (partida.getCategoria().getIdCategoria() == categoria) {
				return true;
			}
		}
		return false;
	}

	public long contarCategoriasUnicas(Usuario usuario) {
		List<Partida> partidas = partidaRepo.findByUsuarioAndEstado(usuario, EstadoPartida.FINALIZADA);

		List<Long> categoriasVistas = new ArrayList<>();

		for (Partida p : partidas) {
			if (p.getCategoria() != null) {
				Long idCategoria = p.getCategoria().getIdCategoria();
				if (!categoriasVistas.contains(idCategoria)) {
					categoriasVistas.add(idCategoria);
				}
			}
		}

		return categoriasVistas.size();
	}

}
