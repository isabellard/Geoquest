package co.edu.unbosque.geoquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.Auditoria;
import co.edu.unbosque.geoquest.entity.Usuario;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

	public List<Auditoria> getByUsuarioOrderByFechaDesc(Usuario usuario);

	public List<Auditoria> findAllByOrderByFechaDesc();
}