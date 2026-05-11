package co.edu.unbosque.geoquest.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "partida")
public class Partida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partida")
	private Long idPartida;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = true)
	private Categoria categoria;

	@Column(nullable = false)
	private LocalDateTime fecha = LocalDateTime.now();

	@Column(name = "puntos_totales")
	private int puntosTotales = 0;

	@OneToMany(mappedBy = "partida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PartidaPregunta> preguntas;

	public Partida() {
		// TODO Auto-generated constructor stub
	}

	public Partida(Usuario usuario, Categoria categoria, LocalDateTime fecha, int puntosTotales) {
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
		Partida other = (Partida) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(fecha, other.fecha)
				&& idPartida == other.idPartida && Objects.equals(puntosTotales, other.puntosTotales)
				&& Objects.equals(usuario, other.usuario);
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
	public List<PartidaPregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(List<PartidaPregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", usuario=" + usuario + ", categoria=" + categoria + ", fecha="
				+ fecha + ", puntosTotales=" + puntosTotales + "]";
	}

}
