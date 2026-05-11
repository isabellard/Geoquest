package co.edu.unbosque.geoquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

	// Historial de partidas de un usuario, más reciente primero
	public List<Partida> findByUsuarioIdUsuarioOrderByFechaDesc(Long idUsuario);

	// Partidas de un usuario por categoría
	public List<Partida> findByUsuarioIdUsuarioAndCategoriaIdCategoria(Long idUsuario, Integer idCategoria);
}