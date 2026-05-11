package co.edu.unbosque.geoquest.dto;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.edu.unbosque.geoquest.entity.Usuario.Role;

public class UsuarioDTO implements UserDetails {
 
    private Long idUsuario;

    private String nombre;
 

    private String usuario;
    
    private String password;
    

	private Role role;

    private int puntosTotales = 0;
 
    private List<PartidaDTO> partidas;
    
    private boolean accountNonExpired;

	/**
	 * Indica si la cuenta del usuario no está bloqueada.
	 */
	private boolean accountNonLocked;

	/**
	 * Indica si las credenciales del usuario no han expirado.
	 */
	private boolean credentialsNonExpired;

	/**
	 * Indica si la cuenta del usuario está habilitada.
	 */
	private boolean enabled;


    /**
	 * Constructor por defecto.
	 * Inicializa un usuario con valores predeterminados:
	 * - Cuenta no expirada
	 * - Cuenta no bloqueada
	 * - Credenciales no expiradas
	 * - Cuenta habilitada
	 * - Rol de usuario normal (USER)
	 */
	public UsuarioDTO() {
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
		this.role = Role.USER;
	}
    
	public UsuarioDTO(String nombre, String usuario, String password, Role rol) {
		this();
		this.nombre = nombre; 
		this.usuario = usuario;
		this.password = password;
		this.role=rol;
	}

	
	public UsuarioDTO(String nombre, String usuario, Role role, int puntosTotales) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.role = role;
		this.puntosTotales = puntosTotales;
	}
	
	/**
	 * Constructor con nombre de usuario, contraseña y rol específico.
	 * 
	 * @param username Nombre de usuario
	 * @param password Contraseña del usuario
	 * @param rol Rol asignado al usuario
	 */
	public UsuarioDTO(String usuario, String password, Role rol) {
		this();
		this.usuario = usuario;
		this.password = password;
		this.role=rol;
	}


	/**
	 * Enumeración que define los roles disponibles en el sistema.
	 * 
	 * USER: Usuario regular con permisos básicos.
	 * ADMIN: Administrador con permisos completos.
	 */
	public enum Role {
		/** Usuario regular con permisos básicos */
		USER, 
		/** Administrador con permisos completos */
		ADMIN
	}
	
	/**
	 * Obtiene las autoridades (roles) asignadas al usuario.
	 * Implementación del método de la interfaz UserDetails.
	 * 
	 * @return Colección de autoridades del usuario con el prefijo "ROLE_"
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, nombre, puntosTotales, usuario);
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
		return idUsuario == other.idUsuario && Objects.equals(nombre, other.nombre)
				&& puntosTotales == other.puntosTotales && Objects.equals(usuario, other.usuario);
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", usuario=" + usuario + ", puntosTotales="
				+ puntosTotales + "]";
	}



	/**
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
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
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    
    
    
}
