package co.edu.unbosque.geoquest.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PartidaDTO {

	private int idPartida;
	private UsuarioDTO usuario;
	private CategoriaDTO categoria;
	private LocalDateTime fecha = LocalDateTime.now();
	private Integer puntosTotales = 0;
	private List<PartidaPreguntaDTO> preguntas;

	public PartidaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PartidaDTO(UsuarioDTO usuario, CategoriaDTO categoria, LocalDateTime fecha, Integer puntosTotales) {
		super();
		this.usuario = usuario;
		this.categoria = categoria;
		this.fecha = fecha;
		this.puntosTotales = puntosTotales;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, fecha, idPartida, puntosTotales, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidaDTO other = (PartidaDTO) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(fecha, other.fecha)
				&& idPartida == other.idPartida && Objects.equals(puntosTotales, other.puntosTotales)
				&& Objects.equals(usuario, other.usuario);
	}

	/**
	 * @return the idPartida
	 */
	public int getIdPartida() {
		return idPartida;
	}

	/**
	 * @param idPartida the idPartida to set
	 */
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
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
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the puntosTotales
	 */
	public Integer getPuntosTotales() {
		return puntosTotales;
	}

	/**
	 * @param puntosTotales the puntosTotales to set
	 */
	public void setPuntosTotales(Integer puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	/**
	 * @return the preguntas
	 */
	public List<PartidaPreguntaDTO> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(List<PartidaPreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", usuario=" + usuario + ", categoria=" + categoria + ", fecha="
				+ fecha + ", puntosTotales=" + puntosTotales + "]";
	}

}
