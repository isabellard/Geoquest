package co.edu.unbosque.geoquest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.Categoria;
import co.edu.unbosque.geoquest.entity.Plantilla;


@Repository
public interface PlantillaRepository extends JpaRepository<Plantilla, Long> {

	public List<Plantilla> findByCategoria(Categoria categoria);
	public List<Plantilla> findByCategoriaAndDificultadBase(Categoria Categoria, Short dificultadBase);

}
