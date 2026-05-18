package co.edu.unbosque.geoquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.Auditoria;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    public List<Auditoria> findByNombreUsuarioOrderByFechaDesc(String nombreUsuario);
    public List<Auditoria> findAllByOrderByFechaDesc();
}