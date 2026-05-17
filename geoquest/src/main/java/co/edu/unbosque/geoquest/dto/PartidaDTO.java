package co.edu.unbosque.geoquest.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PartidaDTO {
	private Long idPartida;
	@JsonIgnore
	private UsuarioDTO usuario;
	@JsonIgnore
	private CategoriaDTO categoria;
	private LocalDateTime fecha = LocalDateTime.now();

	private int puntosTotales = 0;
	private int nivelDificultad = 0;
	private int respuestasCorrectas = 0;

	private EstadoPartida estado = EstadoPartida.EN_CURSO;
	private List<PreguntaDTO> preguntas;

	public enum EstadoPartida {
		EN_CURSO, FINALIZADA, ABANDONADA
	}

	public PartidaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PartidaDTO(UsuarioDTO usuario, CategoriaDTO categoria, LocalDateTime fecha, int puntosTotales,
			int nivelDificultad, int respuestasCorrectas, EstadoPartida estado, List<PreguntaDTO> preguntas) {
		super();
		this.usuario = usuario;
		this.categoria = categoria;
		this.fecha = fecha;
		this.puntosTotales = puntosTotales;
		this.nivelDificultad = nivelDificultad;
		this.respuestasCorrectas = respuestasCorrectas;
		this.estado = estado;
		this.preguntas = preguntas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, estado, fecha, idPartida, nivelDificultad, preguntas, puntosTotales,
				respuestasCorrectas, usuario);
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
		return Objects.equals(categoria, other.categoria) && estado == other.estado
				&& Objects.equals(fecha, other.fecha) && Objects.equals(idPartida, other.idPartida)
				&& nivelDificultad == other.nivelDificultad && Objects.equals(preguntas, other.preguntas)
				&& puntosTotales == other.puntosTotales && respuestasCorrectas == other.respuestasCorrectas
				&& Objects.equals(usuario, other.usuario);
	}

	/**
	 * @return the nivelDificultad
	 */
	public int getNivelDificultad() {
		return nivelDificultad;
	}

	/**
	 * @param nivelDificultad the nivelDificultad to set
	 */
	public void setNivelDificultad(int nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}

	/**
	 * @return the respuestasCorrectas
	 */
	public int getRespuestasCorrectas() {
		return respuestasCorrectas;
	}

	/**
	 * @param respuestasCorrectas the respuestasCorrectas to set
	 */
	public void setRespuestasCorrectas(int respuestasCorrectas) {
		this.respuestasCorrectas = respuestasCorrectas;
	}

	/**
	 * @return the preguntas
	 */
	public List<PreguntaDTO> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(List<PreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}

	/**
	 * @return the idPartida
	 */
	public Long getIdPartida() {
		return idPartida;
	}

	/**
	 * @param idPartida the idPartida to set
	 */
	public void setIdPartida(Long idPartida) {
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
	public int getPuntosTotales() {
		return puntosTotales;
	}

	/**
	 * @param puntosTotales the puntosTotales to set
	 */
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	/**
	 * @return the estado
	 */
	public EstadoPartida getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoPartida estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
	    return "Partida [idPartida=" + idPartida + ", estado=" + estado + "]";
	}

}
