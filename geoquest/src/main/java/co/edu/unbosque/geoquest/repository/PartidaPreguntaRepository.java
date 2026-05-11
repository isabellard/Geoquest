package co.edu.unbosque.geoquest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.geoquest.entity.PartidaPregunta;

@Repository
public interface PartidaPreguntaRepository extends JpaRepository<PartidaPregunta, Long> {
 
    // Todas las preguntas de una partida
    public List<PartidaPregunta> findByPartidaIdPartida(Long idPartida);
 
    // Cuántas acertó el usuario en una partida
    @Query("SELECT COUNT(pp) FROM PartidaPregunta pp WHERE pp.partida.idPartida = :idPartida AND pp.correcta = true")
    public Long contarAciertos(@Param("idPartida") Long idPartida);
 
    // Estadísticas del usuario: total respondidas y acertadas
    @Query("SELECT COUNT(pp) FROM PartidaPregunta pp WHERE pp.partida.usuario.idUsuario = :idUsuario")
    public Long totalRespondidas(@Param("idUsuario") Long idUsuario);
 
    @Query("SELECT COUNT(pp) FROM PartidaPregunta pp WHERE pp.partida.usuario.idUsuario = :idUsuario AND pp.correcta = true")
    public Long totalAcertadas(@Param("idUsuario") Long idUsuario);
}