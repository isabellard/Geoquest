package co.edu.unbosque.geoquest.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class PreguntaDTO {

	private Long idPregunta; 
	private String enunciado;
	private int dificultad; 
	@JsonIgnore
	private PartidaDTO partida;
	@JsonIgnore
	private PlantillaDTO plantilla;
	@JsonIgnore
	private PaisDTO pais;
	private List<RespuestaDTO> respuesta;
	
	public PreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PreguntaDTO(String enunciado, int dificultad, PartidaDTO partida, PlantillaDTO plantilla, PaisDTO pais,
			List<RespuestaDTO> respuesta) {
		super();
		this.enunciado = enunciado;
		this.dificultad = dificultad;
		this.partida = partida;
		this.plantilla = plantilla;
		this.pais = pais;
		this.respuesta = respuesta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dificultad, enunciado, idPregunta, pais, partida, plantilla, respuesta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreguntaDTO other = (PreguntaDTO) obj;
		return dificultad == other.dificultad && Objects.equals(enunciado, other.enunciado)
				&& Objects.equals(idPregunta, other.idPregunta) && Objects.equals(pais, other.pais)
				&& Objects.equals(partida, other.partida) && Objects.equals(plantilla, other.plantilla)
				&& Objects.equals(respuesta, other.respuesta);
	}

	/**
	 * @return the idPregunta
	 */
	public Long getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * @param enunciado the enunciado to set
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	/**
	 * @return the dificultad
	 */
	public int getDificultad() {
		return dificultad;
	}

	/**
	 * @param dificultad the dificultad to set
	 */
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	/**
	 * @return the partida
	 */
	public PartidaDTO getPartida() {
		return partida;
	}

	/**
	 * @param partida the partida to set
	 */
	public void setPartida(PartidaDTO partida) {
		this.partida = partida;
	}

	/**
	 * @return the plantilla
	 */
	public PlantillaDTO getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(PlantillaDTO plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * @return the pais
	 */
	public PaisDTO getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	/**
	 * @return the respuesta
	 */
	public List<RespuestaDTO> getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(List<RespuestaDTO> respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
	    return "Pregunta [idPregunta=" + idPregunta + ", enunciado=" + enunciado + "]";
	}
	
	

	
	

}
