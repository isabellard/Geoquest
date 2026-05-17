package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.dto.LogroDTO;
import co.edu.unbosque.geoquest.entity.Logro;
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

		int partidasJugadas = (int) partidaRepo.countByUsuarioAndEstado(usuario, EstadoPartida.FINALIZADA);
		int puntosTotales = usuario.getPuntosTotales();
		int rankingPos = userSer.getRankingByUsername(usuario.getUsername());

		for (Logro logro : todosLogros) {
			if (idsDesbloqueados.contains(logro.getIdLogro()))
				continue;

			boolean desbloquear = switch (logro.getTipo()) {
			case PRIMERA_VICTORIA -> partidasJugadas >= 1;
			case PARTIDAS_JUGADAS -> (logro.getDescripcion().equals("Explorer") && partidasJugadas >= 10)
					|| (logro.getDescripcion().equals("Veteran") && partidasJugadas >= 50);
			case PUNTOS_TOTALES -> (logro.getDescripcion().equals("Collector") && puntosTotales >= 1000)
					|| (logro.getDescripcion().equals("Millionaire") && puntosTotales >= 5000);
			case RANKING -> rankingPos <= 10;
			default -> false;
			};

			if (desbloquear) {
				logrosUsuario.add(logro);
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

}
