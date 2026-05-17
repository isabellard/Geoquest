package co.edu.unbosque.geoquest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.geoquest.entity.Logro;
import java.util.List;
import co.edu.unbosque.geoquest.entity.Usuario;


public interface LogroRepository extends JpaRepository<Logro, Long>{

	List<Logro> findByUsuarios(List<Usuario> usuarios);
	
}
