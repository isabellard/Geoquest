package co.edu.unbosque.geoquest.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private Long idRespuesta;

	@Column(name = "es_correcta")
	private boolean esCorrecta;

	@Column(name = "respuesta_completa", length = 500)
	private String enunciado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;

	public Respuesta() {
		// TODO Auto-generated constructor stub
	}

	public Respuesta(boolean esCorrecta, String enunciado, Pregunta pregunta) {
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
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", esCorrecta=" + esCorrecta + ", enunciado=" + enunciado
				+ ", pregunta=" + pregunta + "]";
	}
	
	

}
