package co.edu.unbosque.geoquest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.Pregunta;


import java.util.List;


public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{

	public List<Pregunta> findByPartida(Partida partida);
	

	
}
