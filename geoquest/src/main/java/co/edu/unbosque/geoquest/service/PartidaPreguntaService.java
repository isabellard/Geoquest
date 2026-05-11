package co.edu.unbosque.geoquest.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.entity.Categoria;
import co.edu.unbosque.geoquest.entity.Pais;
import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.PartidaPregunta;
import co.edu.unbosque.geoquest.entity.Plantilla;
import co.edu.unbosque.geoquest.repository.*;

@Service
public class PartidaPreguntaService implements CRUDOperation<PartidaPregunta>{

    private final CategoriaRepository categoriaRepository;
	@Autowired
    private PaisRepository paisRepository;
    
    @Autowired
    private PlantillaRepository plantillaRepository;
    
    @Autowired
    private PartidaRepository partidaRepository;
    
    @Autowired
    private PartidaPreguntaRepository partidaPreguntaRepository;
    
    private final Random random = new Random();

    PartidaPreguntaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    /**
     * Genera una pregunta basada en categoría y dificultad
     */
    public PartidaPregunta generarPregunta(Long partidaId, Long idCategoria, 
                                           int dificultadDeseada) {
        
        Partida partida = partidaRepository.findById(partidaId)
            .orElseThrow(() -> new RuntimeException("Partida no encontrada"));
        
        Categoria categoria = categoriaRepository.findById(idCategoria).get(); 
        // 1. Seleccionar plantilla según categoría y dificultad
        List<Plantilla> plantillas = plantillaRepository
            .findByCategoria(categoria);
        
        if (plantillas.isEmpty()) {
            plantillas = plantillaRepository.findByCategoria(categoria);
        }
        
        Plantilla plantilla = plantillas.get(random.nextInt(plantillas.size()));
        
        // 2. Seleccionar país según la dificultad (basado en popularidad)
        List<Pais> paises = seleccionarPaisesSegunDificultad(dificultadDeseada);
        Pais pais = paises.get(random.nextInt(paises.size()));
        
        // 3. Construir la pregunta reemplazando los placeholders
        String enunciado = construirEnunciado(plantilla.getEnunciado(), pais, null);
        
        // 4. Obtener la respuesta correcta
        String respuestaCorrecta = obtenerRespuestaCorrecta(plantilla, pais);
        
        // 5. Crear la pregunta
        PartidaPregunta pregunta = new PartidaPregunta();
        pregunta.setPartida(partida);
        pregunta.setPais(pais);
        pregunta.setPlantilla(plantilla);
        pregunta.setRespuestaDada(respuestaCorrecta); // Asumiendo que tienes este campo
        pregunta.setPuntos(calcularPuntos(dificultadDeseada));
        
        return pregunta;
    }
    
    /**
     * Selecciona países según dificultad (basado en popularidad)
     * popularidad 5 = más fáciles (países conocidos)
     * popularidad 75 = más difíciles (países menos conocidos)
     */
    private List<Pais> seleccionarPaisesSegunDificultad(Integer dificultad) {
        Short popularidadMaxima;
        
        switch(dificultad) {
            case 1:
                popularidadMaxima = 5;
                break;
            case 2: 
                popularidadMaxima = 30; 
                break;
            case 3: 
                popularidadMaxima = 75;
                break;
            default:
                popularidadMaxima = 75;
        }
        
        return paisRepository.findByPopularidadEquals(popularidadMaxima);
    }
    
    /**
     * Construye el enunciado reemplazando {pais} y {dato}
     */
    private String construirEnunciado(String plantilla, Pais pais, String datoExtra) {
        String enunciado = plantilla.replace("{pais}", pais.getNombre());
        
        if (datoExtra != null) {
            enunciado = enunciado.replace("{dato}", datoExtra);
        }
        
        return enunciado;
    }
    
    /**
     * Obtiene la respuesta correcta según el tipo de plantilla
     */
    private String obtenerRespuestaCorrecta(Plantilla plantilla, Pais pais) {
    	int categoria = (int)(long) plantilla.getCategoria().getIdCategoria(); 
        switch(categoria) {
            case 1: // Capitales
                return pais.getCapital();
            case 2: // Banderas
                return pais.getBanderaUrl();      
            case 3: // Idiomas
                if (plantilla.getEnunciado().contains("In which country")) {
                    // Pregunta: "In which country is X spoken?"
                    // Esto requiere lógica adicional
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
                return pais.getContinente().getNombre();
                
            case 7: // Población
                if (plantilla.getEnunciado().contains("largest population")) {
                    // Buscar país con mayor población
                    return paisRepository.findTopByOrderByPoblacionDesc().getNombre();
                } else if (plantilla.getEnunciado().contains("smallest population")) {
                    // Buscar país con menor población
                    return paisRepository.findTopByOrderByPoblacionAsc().getNombre();
                } else {
                    return String.valueOf(pais.getPoblacion());
                }
                
            default:
                return "";
        }
    }
    
    /**
     * Calcula puntos según dificultad y tiempo
     */
    private int calcularPuntos(Integer dificultad) {
        int puntosBase = dificultad * 100;
        return puntosBase;
    }

	@Override
	public int create(PartidaPregunta data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PartidaPregunta> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Long id, PartidaPregunta newData) {
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
