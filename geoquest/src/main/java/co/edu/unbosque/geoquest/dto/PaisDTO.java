package co.edu.unbosque.geoquest.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
public class PaisDTO {

	private Long idPais;
	private ContinenteDTO continente;
	private String nombre;
	private String capital;
	private String idioma;
	private String moneda;
	private String codigoTelefonico;
	private String banderaUrl;
	private Long poblacion;
	private Short popularidad;
	@JsonIgnore
	private List<PreguntaDTO> preguntas;

	public PaisDTO() {
		// TODO Auto-generated constructor stub
	}


	public PaisDTO(Long idPais, ContinenteDTO continenteDTO, String nombre, String capital, String idioma, String moneda,
			String codigoTelefonico, String banderaUrl, Long poblacion, Short popularidad, List<PreguntaDTO> preguntas) {
		super();
		this.idPais = idPais;
		this.continente = continenteDTO;
		this.nombre = nombre;
		this.capital = capital;
		this.idioma = idioma;
		this.moneda = moneda;
		this.codigoTelefonico = codigoTelefonico;
		this.banderaUrl = banderaUrl;
		this.poblacion = poblacion;
		this.popularidad = popularidad;
		this.preguntas = preguntas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(banderaUrl, capital, codigoTelefonico, continente, idPais, idioma, moneda, nombre,
				poblacion, popularidad, preguntas);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaisDTO other = (PaisDTO) obj;
		return Objects.equals(banderaUrl, other.banderaUrl) && Objects.equals(capital, other.capital)
				&& Objects.equals(codigoTelefonico, other.codigoTelefonico)
				&& Objects.equals(continente, other.continente) && Objects.equals(idPais, other.idPais)
				&& Objects.equals(idioma, other.idioma) && Objects.equals(moneda, other.moneda)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(poblacion, other.poblacion)
				&& Objects.equals(popularidad, other.popularidad) && Objects.equals(preguntas, other.preguntas);
	}


	/**
	 * @return the idPais
	 */
	public Long getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	

	/**
	 * @return the continenteDTO
	 */
	public ContinenteDTO getContinente() {
		return continente;
	}


	/**
	 * @param continenteDTO the continenteDTO to set
	 */
	public void setContinente(ContinenteDTO continente) {
		this.continente = continente;
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
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the codigoTelefonico
	 */
	public String getCodigoTelefonico() {
		return codigoTelefonico;
	}

	/**
	 * @param codigoTelefonico the codigoTelefonico to set
	 */
	public void setCodigoTelefonico(String codigoTelefonico) {
		this.codigoTelefonico = codigoTelefonico;
	}

	/**
	 * @return the banderaUrl
	 */
	public String getBanderaUrl() {
		return banderaUrl;
	}

	/**
	 * @param banderaUrl the banderaUrl to set
	 */
	public void setBanderaUrl(String banderaUrl) {
		this.banderaUrl = banderaUrl;
	}

	/**
	 * @return the poblacion
	 */
	public Long getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(Long poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the popularidad
	 */
	public Short getPopularidad() {
		return popularidad;
	}

	/**
	 * @param popularidad the popularidad to set
	 */
	public void setPopularidad(Short popularidad) {
		this.popularidad = popularidad;
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


	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", continenteDTO=" + continente + ", nombre=" + nombre + ", capital="
				+ capital + ", idioma=" + idioma + ", moneda=" + moneda + ", codigoTelefonico=" + codigoTelefonico
				+ ", banderaUrl=" + banderaUrl + ", poblacion=" + poblacion + ", popularidad=" + popularidad
				+ ", preguntas=" + preguntas + "]";
	}


}
