package co.edu.unbosque.geoquest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.Continente;

@Repository
public interface ContinenteRepository extends JpaRepository<Continente, Long> {
	public Optional<Continente> findByNombre(String nombre);
}
