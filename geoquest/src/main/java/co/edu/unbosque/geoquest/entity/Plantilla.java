package co.edu.unbosque.geoquest.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plantilla")
public class Plantilla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plantilla")
	private Long idPlantilla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;

	@Column(nullable = false, length = 255)
	private String enunciado;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_respuesta", nullable = false)
	private TipoRespuesta tipoRespuesta;

	@Column(name = "dificultad_base", nullable = false)
	private int dificultadBase;

	@JsonIgnore
	@OneToMany(mappedBy = "plantilla")
	private List<Pregunta> preguntas;

	public enum TipoRespuesta {
		text, image
	}

	public Plantilla() {
	}

	

	public Plantilla(Categoria categoria, String enunciado, TipoRespuesta tipoRespuesta, int dificultadBase,
			List<Pregunta> preguntas) {
		super();
		this.categoria = categoria;
		this.enunciado = enunciado;
		this.tipoRespuesta = tipoRespuesta;
		this.dificultadBase = dificultadBase;
		this.preguntas = preguntas;
	}



	@Override
	public int hashCode() {
		return Objects.hash(categoria, dificultadBase, enunciado, idPlantilla, tipoRespuesta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plantilla other = (Plantilla) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(dificultadBase, other.dificultadBase)
				&& Objects.equals(enunciado, other.enunciado) && idPlantilla == other.idPlantilla
				&& tipoRespuesta == other.tipoRespuesta;
	}


	/**
	 * @return the dificultadBase
	 */
	public int getDificultadBase() {
		return dificultadBase;
	}

	/**
	 * @param dificultadBase the dificultadBase to set
	 */
	public void setDificultadBase(int dificultadBase) {
		this.dificultadBase = dificultadBase;
	}



	/**
	 * @return the preguntas
	 */
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}



	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}



	/**
	 * @return the idPlantilla
	 */
	public Long getIdPlantilla() {
		return idPlantilla;
	}

	/**
	 * @param idPlantilla the idPlantilla to set
	 */
	public void setIdPlantilla(Long idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	 * @return the tipoRespuesta
	 */
	public TipoRespuesta getTipoRespuesta() {
		return tipoRespuesta;
	}

	/**
	 * @param tipoRespuesta the tipoRespuesta to set
	 */
	public void setTipoRespuesta(TipoRespuesta tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	@Override
	public String toString() {
		return "Plantilla [idPlantilla=" + idPlantilla + ", categoria=" + categoria + ", enunciado=" + enunciado
				+ ", tipoRespuesta=" + tipoRespuesta + ", dificultadBase=" + dificultadBase + "]";
	}

}
