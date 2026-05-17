package co.edu.unbosque.geoquest.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pregunta")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregunta")
	private Long idPregunta; 
	private String enunciado;
	private int dificultad; 
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_partida", nullable = false)
	private Partida partida;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_plantilla", nullable = false)
	private Plantilla plantilla;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;
	
	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Respuesta> respuesta;
	
	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	public Pregunta(String enunciado, int dificultad, Partida partida, Plantilla plantilla, Pais pais,
			List<Respuesta> respuesta) {
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
		Pregunta other = (Pregunta) obj;
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
	public Partida getPartida() {
		return partida;
	}

	/**
	 * @param partida the partida to set
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * @return the plantilla
	 */
	public Plantilla getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the respuesta
	 */
	public List<Respuesta> getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(List<Respuesta> respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
	    return "Pregunta [idPregunta=" + idPregunta + ", enunciado=" + enunciado + "]";
	}
	

	
	

}
