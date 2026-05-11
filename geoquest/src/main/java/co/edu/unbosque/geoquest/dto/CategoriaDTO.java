package co.edu.unbosque.geoquest.dto;
import java.util.List;
import java.util.Objects;

public class CategoriaDTO {

	private int idCategoria;
	private String nombre;
	private List<PlantillaDTO> plantillas;
	private List<PartidaDTO> partidas;

	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(String nombre) {
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
		CategoriaDTO other = (CategoriaDTO) obj;
		return idCategoria == other.idCategoria && Objects.equals(nombre, other.nombre)
				&& Objects.equals(plantillas, other.plantillas);
	}

	/**
	 * @return the idCategoria
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(Integer idCategoria) {
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
	public List<PlantillaDTO> getPlantillas() {
		return plantillas;
	}

	/**
	 * @param plantillas the plantillas to set
	 */
	public void setPlantillas(List<PlantillaDTO> plantillas) {
		this.plantillas = plantillas;
	}

	/**
	 * @return the partidas
	 */
	public List<PartidaDTO> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(List<PartidaDTO> partidas) {
		this.partidas = partidas;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", plantillas=" + plantillas + "]";
	}

}