package co.edu.unbosque.geoquest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unbosque.geoquest.entity.Respuesta;
import jakarta.transaction.Transactional;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

	public Optional<Respuesta> findById(Long id);
	@Transactional
	@Modifying
	@Query("""
		    DELETE FROM Respuesta r
		    WHERE r.esCorrecta = false
		    AND r.pregunta.partida.idPartida = :idPartida
		""")
		void borrarIncorrectasPorPartida(@Param("idPartida") Long idPartida);

}
