package co.edu.unbosque.geoquest.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

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
	private Short dificultadBase;

	@OneToMany(mappedBy = "plantilla", fetch = FetchType.LAZY)
	private List<PartidaPregunta> partidaPreguntas;

	public enum TipoRespuesta {
		text, image
	}

	public Plantilla() {
		// TODO Auto-generated constructor stub
	}

	public Plantilla(Categoria categoria, String enunciado, TipoRespuesta tipoRespuesta, Short dificultadBase) {
		super();
		this.categoria = categoria;
		this.enunciado = enunciado;
		this.tipoRespuesta = tipoRespuesta;
		this.dificultadBase = dificultadBase;
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
	 * @return the partidaPreguntas
	 */
	public List<PartidaPregunta> getPartidaPreguntas() {
		return partidaPreguntas;
	}

	/**
	 * @param partidaPreguntas the partidaPreguntas to set
	 */
	public void setPartidaPreguntas(List<PartidaPregunta> partidaPreguntas) {
		this.partidaPreguntas = partidaPreguntas;
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

	/**
	 * @return the dificultadBase
	 */
	public Short getDificultadBase() {
		return dificultadBase;
	}

	/**
	 * @param dificultadBase the dificultadBase to set
	 */
	public void setDificultadBase(Short dificultadBase) {
		this.dificultadBase = dificultadBase;
	}


	@Override
	public String toString() {
		return "Plantilla [idPlantilla=" + idPlantilla + ", categoria=" + categoria + ", enunciado=" + enunciado
				+ ", tipoRespuesta=" + tipoRespuesta + ", dificultadBase=" + dificultadBase + "]";
	}

}
