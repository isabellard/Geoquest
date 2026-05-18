package co.edu.unbosque.geoquest.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

	/**
	 * Número de versión para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(nullable = false, unique = true, length = 150)
	private String nombreUsuario;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "puntos_totales")
	private int puntosTotales = 0;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Partida> partidas;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "usuario_logro", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_logro"))
	private List<Logro> logros;

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
	 * Constructor por defecto. Inicializa un usuario con valores predeterminados: -
	 * Cuenta no expirada - Cuenta no bloqueada - Credenciales no expiradas - Cuenta
	 * habilitada - Rol de usuario normal (USER)
	 */
	public Usuario() {
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
		this.role = Role.USER;
	}

	/**
	 * Constructor con nombre de usuario, contraseña y rol específico.
	 * 
	 * @param username Nombre de usuario
	 * @param password Contraseña del usuario
	 * @param rol      Rol asignado al usuario
	 */
	public Usuario(String nombreUsuario, String password, Role role) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.role = role;
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
	}
	

	/**
	 * Constructor con nombre de usuario, contraseña y rol específico.
	 * 
	 * @param username Nombre de usuario
	 * @param password Contraseña del usuario
	 */
	public Usuario(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
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

	/**
	 * Obtiene las autoridades (roles) asignadas al usuario. Implementación del
	 * método de la interfaz UserDetails.
	 * 
	 * @return Colección de autoridades del usuario con el prefijo "ROLE_"
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Usuario other = (Usuario) obj;
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
	public List<Partida> getPartidas() {
		return partidas;
	}

	/**
	 * @param partidas the partidas to set
	 */
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	/**
	 * @return the logros
	 */
	public List<Logro> getLogros() {
		return logros;
	}

	/**
	 * @param logros the logros to set
	 */
	public void setLogros(List<Logro> logros) {
		this.logros = logros;
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

	@JsonIgnore
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", role=" + role
				+ ", puntosTotales=" + puntosTotales
				+ ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked
				+ ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled + "]";
	}


	

	

}
