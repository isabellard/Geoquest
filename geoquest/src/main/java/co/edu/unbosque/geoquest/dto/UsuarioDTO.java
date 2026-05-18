package co.edu.unbosque.geoquest.dto;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import co.edu.unbosque.geoquest.entity.Auditoria;

public class UsuarioDTO {

	private Long idUsuario;
	private String nombreUsuario;
	private String password;
	private Role role;
	private int puntosTotales = 0;
	private boolean accountNonLocked;
	@JsonIgnore
	private List<PartidaDTO> partidas;
	@JsonIgnore
	private List<LogroDTO> logros;
	@JsonIgnore
	private List<Auditoria> auditorias;

	/**
	 * Constructor por defecto. Inicializa un usuario con valores predeterminados: -
	 * Cuenta no expirada - Cuenta no bloqueada - Credenciales no expiradas - Cuenta
	 * habilitada - Rol de usuario normal (USER)
	 */
	public UsuarioDTO() {
		this.accountNonLocked = true;
	}

	/**
	 * Constructor con nombre de usuario, contraseña y rol específico.
	 * 
	 * @param username Nombre de usuario
	 * @param password Contraseña del usuario
	 * @param rol      Rol asignado al usuario
	 */
	public UsuarioDTO(String nombreUsuario, String password, Role role) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.role = role;
		this.accountNonLocked = true;

	}

	/**
	 * Constructor con nombre de usuario, contraseña y rol específico.
	 * 
	 * @param username Nombre de usuario
	 * @param password Contraseña del usuario
	 */
	public UsuarioDTO(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.accountNonLocked = true;
	}

	/**
	 * Enumeración que define los roles disponibles en el sistema.
	 * 
	 * USER: Usuario regular con permisos básicos. ADMIN: Administrador con permisos
	 * completos.
	 */
	public enum Role {
		/** Usuario regular con permisos básicos */
		USER,
		/** Administrador con permisos completos */
		ADMIN
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, puntosTotales, nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return idUsuario == other.idUsuario && puntosTotales == other.puntosTotales
				&& Objects.equals(nombreUsuario, other.nombreUsuario);
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the puntosTotales
	 */
	public int getPuntosTotales() {
		return puntosTotales;
	}

	/**
	 * @param puntosTotales the puntosTotales to set
	 */
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
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
	 * @return the logros
	 */
	public List<LogroDTO> getLogros() {
		return logros;
	}

	/**
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param logros the logros to set
	 */
	public void setLogros(List<LogroDTO> logros) {
		this.logros = logros;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", role=" + role
				+ ", puntosTotales=" + puntosTotales + "]";
	}

}
