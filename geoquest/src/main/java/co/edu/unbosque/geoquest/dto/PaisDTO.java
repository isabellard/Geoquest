package co.edu.unbosque.geoquest.dto;

public class PaisDTO {

	private int idPais;
	private ContinenteDTO continente;
	private String nombre;
	private String capital;
	private String idioma;
	private String moneda;
	private String codigoTelefonico;
	private String banderaUrl;
	private Long poblacion;
	private Short popularidad;

	public PaisDTO() {
		// TODO Auto-generated constructor stub
	}

	public PaisDTO(ContinenteDTO continente, String nombre, String capital, String idioma, String moneda,
			String codigoTelefonico, String banderaUrl, Long poblacion, Short popularidad) {
		super();
		this.continente = continente;
		this.nombre = nombre;
		this.capital = capital;
		this.idioma = idioma;
		this.moneda = moneda;
		this.codigoTelefonico = codigoTelefonico;
		this.banderaUrl = banderaUrl;
		this.poblacion = poblacion;
		this.popularidad = popularidad;
	}

	/**
	 * @return the idPais
	 */
	public Integer getIdPais() {
		return idPais;
	}

	/**
	 * @param idPais the idPais to set
	 */
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	/**
	 * @return the continente
	 */
	public ContinenteDTO getContinente() {
		return continente;
	}

	/**
	 * @param continente the continente to set
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

	@Override
	public String toString() {
		return "Pais [continente=" + continente + ", nombre=" + nombre + ", capital=" + capital
				+ ", idioma=" + idioma + ", moneda=" + moneda + ", codigoTelefonico=" + codigoTelefonico
				+ ", banderaUrl=" + banderaUrl + ", poblacion=" + poblacion + ", popularidad=" + popularidad + "]";
	}

}
