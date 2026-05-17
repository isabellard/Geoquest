package co.edu.unbosque.geoquest.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "logro")
public class Logro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_logro")
	private Long idLogro;

	private String descripcion;
	private String objetivo;

	@Column(nullable = false, length = 150)
	@Enumerated(EnumType.STRING)
	private TipoLogro tipo;

	private int puntosRecompensa; 

	@JsonIgnore
	@ManyToMany(mappedBy = "logros")
	private List<Usuario> usuarios;

	public enum TipoLogro {
		PARTIDAS_JUGADAS, RESPUESTAS_CORRECTAS, PUNTOS_TOTALES, CATEGORIAS_DESCUBIERTAS, PRIMERA_VICTORIA, MASTER_CATEGORIA, RANKING 
	}

	public Logro() {
		// TODO Auto-generated constructor stub
	}
	
	public Logro(String descripcion, String objetivo, TipoLogro tipo, int puntosRecompensa, List<Usuario> usuarios) {
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
		Logro other = (Logro) obj;
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Logro [idLogro=" + idLogro + ", descripcion=" + descripcion + ", objetivo=" + objetivo + ", tipo="
				+ tipo + ", puntosRecompensa=" + puntosRecompensa + ", usuarios=" + usuarios + "]";
	}

	

}
