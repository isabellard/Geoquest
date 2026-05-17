package co.edu.unbosque.geoquest.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "partida")
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partida")
	private Long idPartida;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = true)
	private Categoria categoria;

	@Column(nullable = false)
	private LocalDateTime fecha = LocalDateTime.now();

	@Column(name = "puntos_totales")
	private int puntosTotales = 0;
	
	@Column(name = "nivel_dificultad")
	private int nivelDificultad = 0;
	
	@Column(name = "respuestas_correctas")
	private int respuestasCorrectas = 0;

	@Enumerated(EnumType.STRING)
	private EstadoPartida estado = EstadoPartida.EN_CURSO;

	@OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pregunta> preguntas;

	public enum EstadoPartida {
	    EN_CURSO,
	    FINALIZADA,
	    ABANDONADA
	}
	
	public Partida() {
		// TODO Auto-generated constructor stub
	}


	public Partida(Usuario usuario, Categoria categoria, LocalDateTime fecha, int puntosTotales, int nivelDificultad,
			int respuestasCorrectas, EstadoPartida estado, List<Pregunta> preguntas) {
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
		Partida other = (Partida) obj;
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
	public Usuario getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
