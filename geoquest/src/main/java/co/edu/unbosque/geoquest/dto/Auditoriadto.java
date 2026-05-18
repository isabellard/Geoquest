package co.edu.unbosque.geoquest.dto;

import java.time.LocalDateTime;

import co.edu.unbosque.geoquest.entity.Usuario;


public class AuditoriaDTO {

    private Long idAuditoria;
    private Usuario usuario;
    private TipoAccion tipoAccion;

    private String detalle;

    private LocalDateTime fecha = LocalDateTime.now();

    public enum TipoAccion {
        LOGIN, PARTIDA, LOGRO, REGISTRO
    }

    public AuditoriaDTO() {
		// TODO Auto-generated constructor stub
	}
    
	public AuditoriaDTO(Usuario usuario, TipoAccion tipoAccion, String detalle) {
		super();
		this.usuario = usuario;
		this.tipoAccion = tipoAccion;
		this.detalle = detalle;
		this.fecha = fecha;
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
		return "Auditoria [idAuditoria=" + idAuditoria 
				+ tipoAccion + ", detalle=" + detalle + ", fecha=" + fecha + "]";
	}

 
    
}
