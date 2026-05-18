package co.edu.unbosque.geoquest.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class AudioriaDTO {

    private Long idAuditoria;
    private String nombreUsuario;
    private TipoAccion tipoAccion;

    private String detalle;

    private LocalDateTime fecha = LocalDateTime.now();

    public enum TipoAccion {
        LOGIN, PARTIDA, LOGRO, REGISTRO
    }

    public AudioriaDTO(String nombreUsuario, TipoAccion tipo, String detalle) {
        this.nombreUsuario = nombreUsuario;
        this.tipoAccion = tipo;
        this.detalle = detalle;
        this.fecha = LocalDateTime.now();
    }

    public AudioriaDTO() {}

	public AudioriaDTO(String nombreUsuario, TipoAccion tipoAccion, String detalle, LocalDateTime fecha) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.tipoAccion = tipoAccion;
		this.detalle = detalle;
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(detalle, fecha, idAuditoria, nombreUsuario, tipoAccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AudioriaDTO other = (AudioriaDTO) obj;
		return Objects.equals(detalle, other.detalle) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(idAuditoria, other.idAuditoria) && Objects.equals(nombreUsuario, other.nombreUsuario)
				&& tipoAccion == other.tipoAccion;
	}

	/**
	 * @return the idAuditoria
	 */
	public Long getIdAuditoria() {
		return idAuditoria;
	}

	/**
	 * @param idAuditoria the idAuditoria to set
	 */
	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the tipoAccion
	 */
	public TipoAccion getTipoAccion() {
		return tipoAccion;
	}

	/**
	 * @param tipoAccion the tipoAccion to set
	 */
	public void setTipoAccion(TipoAccion tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	@Override
	public String toString() {
		return "Auditoria [idAuditoria=" + idAuditoria + ", nombreUsuario=" + nombreUsuario + ", tipoAccion="
				+ tipoAccion + ", detalle=" + detalle + ", fecha=" + fecha + "]";
	}

 
    
}
