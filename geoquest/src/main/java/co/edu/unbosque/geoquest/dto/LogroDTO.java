package co.edu.unbosque.geoquest.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LogroDTO {
	private Long idLogro;
	private String descripcion;
	private String objetivo;

	private TipoLogro tipo; // PARTIDAS, CORRECTAS, PUNTOS, RACHA

	private int puntosRecompensa; 

	@JsonIgnore
	private List<UsuarioDTO> usuarios;

	public enum TipoLogro {
		PARTIDAS_JUGADAS, RESPUESTAS_CORRECTAS, RESPUESTAS_CORRECTAS_CONSECUTIVAS, PUNTOS_TOTALES, PAISES_DESCUBIERTOS,
		RACHA_DIARIA, PRIMERA_VICTORIA, MASTER_CATEGORIA
	}

	
	public LogroDTO(String descripcion, String objetivo, TipoLogro tipo, int puntosRecompensa, List<UsuarioDTO> usuarios) {
		super();
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.tipo = tipo;
		this.puntosRecompensa = puntosRecompensa;
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idLogro, objetivo, puntosRecompensa, tipo, usuarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogroDTO other = (LogroDTO) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idLogro, other.idLogro)
				&& Objects.equals(objetivo, other.objetivo) && puntosRecompensa == other.puntosRecompensa
				&& tipo == other.tipo && Objects.equals(usuarios, other.usuarios);
	}

	/**
	 * @return the puntosRecompensa
	 */
	public int getPuntosRecompensa() {
		return puntosRecompensa;
	}

	/**
	 * @param puntosRecompensa the puntosRecompensa to set
	 */
	public void setPuntosRecompensa(int puntosRecompensa) {
		this.puntosRecompensa = puntosRecompensa;
	}

	/**
	 * @return the idLogro
	 */
	public Long getIdLogro() {
		return idLogro;
	}

	/**
	 * @param idLogro the idLogro to set
	 */
	public void setIdLogro(Long idLogro) {
		this.idLogro = idLogro;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the objetivo
	 */
	public String getObjetivo() {
		return objetivo;
	}

	/**
	 * @param objetivo the objetivo to set
	 */
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * @return the tipo
	 */
	public TipoLogro getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoLogro tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the usuarios
	 */
	public List<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Logro [idLogro=" + idLogro + ", descripcion=" + descripcion + ", objetivo=" + objetivo + ", tipo="
				+ tipo + ", puntosRecompensa=" + puntosRecompensa + ", usuarios=" + usuarios + "]";
	}

	

}
