package co.edu.unbosque.geoquest.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;

	@Column(nullable = false, unique = true, length = 50)
	private String nombre;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Plantilla> plantillas;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Partida> partidas;

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;

	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria, nombre, plantillas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return idCategoria == other.idCategoria && Objects.equals(nombre, other.nombre)
				&& Objects.equals(plantillas, other.plantillas);
	}

	/**
	 * @return the idCategoria
	 */
	public Long getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the plantillas
	 */
	public List<Plantilla> getPlantillas() {
		return plantillas;
	}

	/**
	 * @param plantillas the plantillas to set
	 */
	public void setPlantillas(List<Plantilla> plantillas) {
		this.plantillas = plantillas;
	}

	/**
	 * @return the partidas
	 */
	public List<Partida> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", plantillas=" + plantillas + "]";
	}

}