package co.edu.unbosque.geoquest.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "continente")
public class Continente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_continente")
	private Long idContinente;

	@Column(nullable = false, unique = true, length = 50)
	private String nombre;

	@JsonIgnore
	@OneToMany(mappedBy = "continente", fetch = FetchType.LAZY)
	private List<Pais> paises;

	public Continente() {
		// TODO Auto-generated constructor stub
	}

	public Continente(String nombre) {
		super();
		this.nombre = nombre;
		}

	@Override
	public int hashCode() {
		return Objects.hash(idContinente, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continente other = (Continente) obj;
		return Objects.equals(idContinente, other.idContinente) && Objects.equals(nombre, other.nombre);
	}

	

	/**
	 * @return the idContinente
	 */
	public Long getIdContinente() {
		return idContinente;
	}

	/**
	 * @param idContinente the idContinente to set
	 */
	public void setIdContinente(Long idContinente) {
		this.idContinente = idContinente;
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
	 * @return the paises
	 */
	public List<Pais> getPaises() {
		return paises;
	}

	/**
	 * @param paises the paises to set
	 */
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	@Override
	public String toString() {
		return "Continente [nombre=" + nombre + "]";
	}
}
