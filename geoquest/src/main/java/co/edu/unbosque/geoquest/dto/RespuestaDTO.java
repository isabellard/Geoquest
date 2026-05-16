package co.edu.unbosque.geoquest.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

public class RespuestaDTO {
	private Long idRespuesta;
	private boolean esCorrecta;
	private String enunciado;
	@JsonIgnore
	private PreguntaDTO pregunta;

	public RespuestaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RespuestaDTO(boolean esCorrecta, String enunciado, PreguntaDTO pregunta) {
		super();
		this.esCorrecta = esCorrecta;
		this.enunciado = enunciado;
		this.pregunta = pregunta;
	}

	/**
	 * @return the idRespuesta
	 */
	public Long getIdRespuesta() {
		return idRespuesta;
	}

	/**
	 * @param idRespuesta the idRespuesta to set
	 */
	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	/**
	 * @return the esCorrecta
	 */
	public boolean isEsCorrecta() {
		return esCorrecta;
	}

	/**
	 * @param esCorrecta the esCorrecta to set
	 */
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
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
	 * @return the pregunta
	 */
	public PreguntaDTO getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(PreguntaDTO pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", esCorrecta=" + esCorrecta + ", enunciado=" + enunciado
				+ ", pregunta=" + pregunta + "]";
	}
	
	

}
