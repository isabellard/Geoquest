package co.edu.unbosque.geoquest.dto;

import java.util.List;
import java.util.Objects;

public class ContinenteDTO {

	private int idContinente;
	private String nombre;
	private List<PaisDTO> paises;

	public ContinenteDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContinenteDTO(String nombre) {
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
		ContinenteDTO other = (ContinenteDTO) obj;
		return Objects.equals(idContinente, other.idContinente) && Objects.equals(nombre, other.nombre);
	}

	/**
	 * @param idContinente the idContinente to set
	 */
	public void setIdContinente(Integer idContinente) {
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
	public List<PaisDTO> getPaises() {
		return paises;
	}

	/**
	 * @param paises the paises to set
	 */
	public void setPaises(List<PaisDTO> paises) {
		this.paises = paises;
	}

	/**
	 * @return the idContinente
	 */
	public Integer getIdContinente() {
		return idContinente;
	}

	@Override
	public String toString() {
		return "Continente [nombre=" + nombre + "]";
	}
}
