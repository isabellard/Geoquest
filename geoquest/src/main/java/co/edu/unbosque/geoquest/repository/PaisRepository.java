package co.edu.unbosque.geoquest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.Continente;
import co.edu.unbosque.geoquest.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	public List<Pais> findByContinente(Continente continente);

	public List<Pais> findByContinenteAndIdPaisNot(Continente continente, Long idPais);

	public List<Pais> findByPopularidadEquals(Short popularidad);
	
	public List<Pais> findByPopularidad(Short popularidad);
	
	public List<Pais> findByPoblacion(Long poblacion);
	
}
