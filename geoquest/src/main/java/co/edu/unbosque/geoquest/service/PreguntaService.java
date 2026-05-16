package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfigurationSource;
import co.edu.unbosque.geoquest.controller.AuthController;
import co.edu.unbosque.geoquest.dto.ContinenteDTO;
import co.edu.unbosque.geoquest.dto.PaisDTO;
import co.edu.unbosque.geoquest.dto.PlantillaDTO;
import co.edu.unbosque.geoquest.dto.PreguntaDTO;
import co.edu.unbosque.geoquest.entity.Pais;
import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.Plantilla;
import co.edu.unbosque.geoquest.entity.Pregunta;
import co.edu.unbosque.geoquest.entity.Respuesta;
import co.edu.unbosque.geoquest.repository.PreguntaRepository;

@Service
public class PreguntaService implements CRUDOperation<PreguntaDTO> {

	private final CorsConfigurationSource corsConfigurationSource;

	private final AuthController authController;

	@Autowired
	private PreguntaRepository preguntaRepo;
	@Autowired
	private PaisService paisService;
	@Autowired
	private PlantillaService plantillaSer;
	@Autowired
	private ModelMapper modelMapper;

	private Random random;

	public PreguntaService(AuthController authController, CorsConfigurationSource corsConfigurationSource) {
		random = new Random();
		this.authController = authController;
		this.corsConfigurationSource = corsConfigurationSource;
	}

	public Pregunta generarPreguntaDificultad(int dificultad, Partida partida) {
		PaisDTO pais = paisService.seleccionaPaiseSegunDificultad(dificultad);
		PlantillaDTO plantilla = plantillaSer.findById(random.nextLong(1, 17));
		String datoExtra = obtenerDatoExtra(plantilla, pais);
		String enunciado = construirEnunciado(plantilla.getEnunciado(), pais, datoExtra);
		int dificultadPregunta = pais.getPopularidad() + plantilla.getDificultadBase();

		Pregunta pregunta = new Pregunta();
		List<Respuesta> listaRespuestas = new ArrayList<>();

		pregunta.setEnunciado(enunciado);
		pregunta.setDificultad(dificultadPregunta);
		pregunta.setPartida(partida);
		pregunta.setPlantilla(modelMapper.map(plantilla, Plantilla.class));
		pregunta.setPais(modelMapper.map(pais, Pais.class));

		if (enunciado.contains("largest")) {
			listaRespuestas = (largestCountry(pais, pregunta));
		} else if (enunciado.contains("smallest")) {
			listaRespuestas = (smallestCountry(pais, pregunta));
		} else {
			Respuesta respuestaCorrecta = new Respuesta(true, obtenerRespuestaCorrecta(plantilla, pais), pregunta);
			listaRespuestas.add(respuestaCorrecta);
			for (int i = 0; i < 3; i++) {
				Respuesta incorrecta = new Respuesta(false, obtenerRespuestaIncorrecta(plantilla, pais), pregunta);
				listaRespuestas.add(incorrecta);
			}
		}

		pregunta.setRespuesta(listaRespuestas);
		preguntaRepo.save(pregunta);
		return pregunta;

	}
	
	public Pregunta generarPreguntaRandom(Partida partida) {
		PaisDTO pais = paisService.findById(random.nextLong(paisService.count()-1));
		PlantillaDTO plantilla = plantillaSer.findById(random.nextLong(1, 17));
		String datoExtra = obtenerDatoExtra(plantilla, pais);
		String enunciado = construirEnunciado(plantilla.getEnunciado(), pais, datoExtra);
		int dificultadPregunta = pais.getPopularidad() + plantilla.getDificultadBase();

		Pregunta pregunta = new Pregunta();
		List<Respuesta> listaRespuestas = new ArrayList<>();

		pregunta.setEnunciado(enunciado);
		pregunta.setDificultad(dificultadPregunta);
		pregunta.setPartida(partida);
		pregunta.setPlantilla(modelMapper.map(plantilla, Plantilla.class));
		pregunta.setPais(modelMapper.map(pais, Pais.class));

		if (enunciado.contains("largest")) {
			listaRespuestas = (largestCountry(pais, pregunta));
		} else if (enunciado.contains("smallest")) {
			listaRespuestas = (smallestCountry(pais, pregunta));
		} else {
			Respuesta respuestaCorrecta = new Respuesta(true, obtenerRespuestaCorrecta(plantilla, pais), pregunta);
			listaRespuestas.add(respuestaCorrecta);
			for (int i = 0; i < 3; i++) {
				Respuesta incorrecta = new Respuesta(false, obtenerRespuestaIncorrecta(plantilla, pais), pregunta);
				listaRespuestas.add(incorrecta);
			}
		}

		pregunta.setRespuesta(listaRespuestas);
		preguntaRepo.save(pregunta);
		return pregunta;

	}
	
	public Pregunta generarPreguntaCategoria(Long categoria, Partida partida) {
		PaisDTO pais = paisService.findById(random.nextLong(paisService.count()-1));
		PlantillaDTO plantilla = plantillaSer.plantillaCategoria(categoria);
		String datoExtra = obtenerDatoExtra(plantilla, pais);
		String enunciado = construirEnunciado(plantilla.getEnunciado(), pais, datoExtra);
		int dificultadPregunta = pais.getPopularidad() + plantilla.getDificultadBase();

		Pregunta pregunta = new Pregunta();
		List<Respuesta> listaRespuestas = new ArrayList<>();

		pregunta.setEnunciado(enunciado);
		pregunta.setDificultad(dificultadPregunta);
		pregunta.setPartida(partida);
		pregunta.setPlantilla(modelMapper.map(plantilla, Plantilla.class));
		pregunta.setPais(modelMapper.map(pais, Pais.class));

		if (enunciado.contains("largest")) {
			listaRespuestas = (largestCountry(pais, pregunta));
		} else if (enunciado.contains("smallest")) {
			listaRespuestas = (smallestCountry(pais, pregunta));
		} else {
			Respuesta respuestaCorrecta = new Respuesta(true, obtenerRespuestaCorrecta(plantilla, pais), pregunta);
			listaRespuestas.add(respuestaCorrecta);
			for (int i = 0; i < 3; i++) {
				Respuesta incorrecta = new Respuesta(false, obtenerRespuestaIncorrecta(plantilla, pais), pregunta);
				listaRespuestas.add(incorrecta);
			}
		}

		pregunta.setRespuesta(listaRespuestas);
		preguntaRepo.save(pregunta);
		return pregunta;

	}
	
	

	public String construirEnunciado(String plantilla, PaisDTO pais, String datoExtra) {
		String enunciado = "";
		if (plantilla.contains("{pais}")) {
			enunciado = plantilla.replace("{pais}", pais.getNombre());
		} else if (plantilla.contains("{dato}") && datoExtra != null) {
			enunciado = plantilla.replace("{dato}", datoExtra);
		} else if (plantilla.contains("flag")) {
			enunciado = plantilla + "{" + pais.getBanderaUrl() + "}";
		} else if (plantilla.contains("t population")) {
			enunciado = plantilla;
		}
		return enunciado;
	}

	public String obtenerRespuestaIncorrecta(PlantillaDTO plantilla, PaisDTO paisCorrecto) {
		int categoria = (int) (long) plantilla.getCategoria().getIdCategoria();
		PaisDTO pais = paisCorrecto;
		while (pais.getIdPais() == paisCorrecto.getIdPais()) {
			pais = paisService.findById((long) random.nextInt(0, (int) paisService.count() - 1));
		}

		switch (categoria) {
		case 1: // Capitales
			return pais.getCapital();
		case 2: // Banderas
			return pais.getNombre();
		case 3: // Idiomas
			if (plantilla.getEnunciado().contains("In which country")) {
				return pais.getNombre();
			} else {
				return pais.getIdioma();
			}
		case 4: // Códigos telefónicos
			if (plantilla.getEnunciado().contains("Which country uses")) {
				return pais.getNombre();
			} else {
				return pais.getCodigoTelefonico();
			}
		case 5: // Monedas
			if (plantilla.getEnunciado().contains("Which country uses")) {
				return pais.getNombre();
			} else {
				return pais.getMoneda();
			}

		case 6: // Continentes
			if (plantilla.getEnunciado().contains("Name a country")) {
				return isNotContinent(paisCorrecto.getContinente(), paisCorrecto);
			} else if (plantilla.getEnunciado().contains("countries is NOT")) {
				return paisCorrecto.getContinente().getPaises()
						.get(random.nextInt(paisCorrecto.getContinente().getPaises().size() - 1)).getNombre();
			} else if (plantilla.getEnunciado().contains("On which ")) {
				return isLocatedContinent(paisCorrecto.getContinente(), paisCorrecto); 
			}

		case 7:
			if (plantilla.getEnunciado().contains("What is")) {
				return pais.getPoblacion() + "";
			}
		default:
			return null;
		}
	}

	public String obtenerRespuestaCorrecta(PlantillaDTO plantilla, PaisDTO pais) {
		int categoria = (int) (long) plantilla.getCategoria().getIdCategoria();
		switch (categoria) {
		case 1: // Capitales
			return pais.getCapital();
		case 2: // Banderas
			return pais.getNombre();
		case 3: // Idiomas
			if (plantilla.getEnunciado().contains("In which country")) {
				return pais.getNombre();
			} else {
				return pais.getIdioma();
			}
		case 4: // Códigos telefónicos
			if (plantilla.getEnunciado().contains("Which country uses")) {
				return pais.getNombre();
			} else {
				return pais.getCodigoTelefonico();
			}
		case 5: // Monedas
			if (plantilla.getEnunciado().contains("Which country uses")) {
				return pais.getNombre();
			} else {
				return pais.getMoneda();
			}

		case 6: // Continentes
			if (plantilla.getEnunciado().contains("Name a country")) {
				return pais.getNombre();
			} else if (plantilla.getEnunciado().contains("countries is NOT")) {
				return isNotContinent(pais.getContinente(), pais);
			} else if (plantilla.getEnunciado().contains("On which ")) {
				return pais.getContinente().getNombre();
			}

		case 7:
			if (plantilla.getEnunciado().contains("What is")) {
				return pais.getPoblacion() + "";
			}
		default:
			return null;
		}
	}

	public String obtenerDatoExtra(PlantillaDTO plantilla, PaisDTO pais) {
		int categoria = (int) (long) plantilla.getCategoria().getIdCategoria();
		switch (categoria) {
		case 1: // Capitales
			return null;
		case 2: // Banderas
			return null;
		case 3: // Idiomas
			if (plantilla.getEnunciado().contains("In which country")) {
				return pais.getIdioma();
			} else {
				return null;
			}
		case 4: // Códigos telefónicos
			if (plantilla.getEnunciado().contains("Which country uses")) {
				return pais.getCodigoTelefonico();
			} else {
				return null;
			}
		case 5: // Monedas
			if (plantilla.getEnunciado().contains("Which country uses")) {
				return pais.getMoneda();
			} else {
				return null;
			}

		case 6: // Continentes
			if (plantilla.getEnunciado().contains("Name a country")
					|| plantilla.getEnunciado().contains("Which of these")) {
				return pais.getContinente().getNombre();
			} else {
				return null;
			}

		case 7: // Población
			return null;
		default:
			return null;
		}
	}

	public String isLocatedContinent(ContinenteDTO continente, PaisDTO pais) {
		PaisDTO paisEncontrado = pais;
		while (paisEncontrado.getContinente().getIdContinente() == continente.getIdContinente()) {
			paisEncontrado = paisService.findById(random.nextLong(0, paisService.count() - 1));
		}
		return paisEncontrado.getContinente().getNombre();
	}

	public String isNotContinent(ContinenteDTO continente, PaisDTO pais) {
		PaisDTO paisEncontrado = pais;
		while (paisEncontrado.getContinente().getIdContinente() == continente.getIdContinente()) {
			paisEncontrado = paisService.findById(random.nextLong(0, paisService.count() - 1));
		}
		return paisEncontrado.getNombre();
	}

	public List<Respuesta> largestCountry(PaisDTO pais, Pregunta pregunta) {
		List<Respuesta> listaRespuestas = new ArrayList<>();
		listaRespuestas.add(new Respuesta(true, pais.getNombre(), pregunta));
		PaisDTO paisI = new PaisDTO();

		while (listaRespuestas.size() != 4) {
			paisI = paisService.findById(random.nextLong(0, paisService.count() - 1));
			if (paisI.getPoblacion() < pais.getPoblacion()) {
				listaRespuestas.add(new Respuesta(false, paisI.getNombre(), pregunta));
			}
		}
		return listaRespuestas;
	}

	public List<Respuesta> smallestCountry(PaisDTO pais, Pregunta pregunta) {
		List<Respuesta> listaRespuestas = new ArrayList<>();
		listaRespuestas.add(new Respuesta(true, pais.getNombre(), pregunta));
		PaisDTO paisI = new PaisDTO();

		while (listaRespuestas.size() != 4) {
			paisI = paisService.findById(random.nextLong(0, paisService.count() - 1));
			if (paisI.getPoblacion() > pais.getPoblacion()) {
				listaRespuestas.add(new Respuesta(false, paisI.getNombre(), pregunta));
			}
		}
		return listaRespuestas;
	}


	@Override
	public int create(PreguntaDTO data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PreguntaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Long id, PreguntaDTO newData) {
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
