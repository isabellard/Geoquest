package co.edu.unbosque.geoquest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.geoquest.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public boolean existsByUsuario(String usuario);
 
    // Top N usuarios por puntos → para ranking
    @Query("SELECT u FROM Usuario u ORDER BY u.puntosTotales DESC")
    public List<Usuario> findTopByPuntos();
    
    /**
	 * Busca un usuario por su nombre de usuario.
	 * 
	 * @param username El nombre de usuario a buscar
	 * @return Un Optional que contiene el usuario si existe, o vacío si no existe
	 */
	public Optional<Usuario> findByUsuario(String usuario);

	/**
	 * Elimina un usuario por su nombre de usuario.
	 * 
	 * @param username El nombre de usuario del usuario a eliminar
	 */
	public void deleteByUsername(String username); 
}
