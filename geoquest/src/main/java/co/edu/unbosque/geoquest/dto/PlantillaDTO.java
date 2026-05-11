package co.edu.unbosque.geoquest.dto;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

public class PlantillaDTO {

	private int idPlantilla;
	private CategoriaDTO categoria;
	private String enunciado;
	private TipoRespuesta tipoRespuesta;
	private Short dificultadBase;
	private List<PartidaPreguntaDTO> partidaPreguntas;

	public enum TipoRespuesta {
		text, image
	}

	public PlantillaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PlantillaDTO(CategoriaDTO categoria, String enunciado, TipoRespuesta tipoRespuesta, Short dificultadBase) {
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
		PlantillaDTO other = (PlantillaDTO) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(dificultadBase, other.dificultadBase)
				&& Objects.equals(enunciado, other.enunciado) && idPlantilla == other.idPlantilla
				&& tipoRespuesta == other.tipoRespuesta;
	}

	/**
	 * @return the partidaPreguntas
	 */
	public List<PartidaPreguntaDTO> getPartidaPreguntas() {
		return partidaPreguntas;
	}

	/**
	 * @param partidaPreguntas the partidaPreguntas to set
	 */
	public void setPartidaPreguntas(List<PartidaPreguntaDTO> partidaPreguntas) {
		this.partidaPreguntas = partidaPreguntas;
	}

	/**
	 * @param idPlantilla the idPlantilla to set
	 */
	public void setIdPlantilla(int idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	/**
	 * @return the idPlantilla
	 */
	public Integer getIdPlantilla() {
		return idPlantilla;
	}

	/**
	 * @param idPlantilla the idPlantilla to set
	 */
	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	/**
	 * @return the categoria
	 */
	public CategoriaDTO getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(CategoriaDTO categoria) {
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
