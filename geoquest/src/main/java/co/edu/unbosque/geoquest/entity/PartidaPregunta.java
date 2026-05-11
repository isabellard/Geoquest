package co.edu.unbosque.geoquest.entity;

import java.util.Objects;

import jakarta.persistence.*;

/**
 * Tabla asociativa ternaria: Partida + Pais + Plantilla
 *
 * Representa una pregunta específica dentro de una partida.
 * No guarda el enunciado ni las opciones (se generaron en memoria),
 * solo guarda qué país + qué plantilla se usaron y cómo respondió el usuario.
 *
 * Desde esta tabla puedes saber:
 *   - Qué preguntas tuvo cada partida
 *   - Si el usuario acertó cada una
 *   - Cuántos puntos ganó por pregunta
 *   - Cuánto tardó en responder
 */
@Entity
@Table(name = "partida_pregunta")
public class PartidaPregunta {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partida_pregunta")
    private Long idPartidaPregunta;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida", nullable = false)
    private Partida partida;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantilla", nullable = false)
    private Plantilla plantilla;
 
    @Column(name = "respuesta_dada", length = 200)
    private String respuestaDada;
 
    @Column(nullable = false)
    private boolean correcta;
 
    @Column(nullable = false)
    private int puntos;
 
    @Column(name = "tiempo_ms")
    private int tiempoMs;
    
    public PartidaPregunta() {
		// TODO Auto-generated constructor stub
	}

	public PartidaPregunta(Partida partida, Pais pais, Plantilla plantilla, String respuestaDada, boolean correcta,
			int puntos, int tiempoMs) {
		super();
		this.partida = partida;
		this.pais = pais;
		this.plantilla = plantilla;
		this.respuestaDada = respuestaDada;
		this.correcta = correcta;
		this.puntos = puntos;
		this.tiempoMs = tiempoMs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(correcta, idPartidaPregunta, pais, partida, plantilla, puntos, respuestaDada, tiempoMs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidaPregunta other = (PartidaPregunta) obj;
		return correcta == other.correcta && idPartidaPregunta == other.idPartidaPregunta
				&& Objects.equals(pais, other.pais) && Objects.equals(partida, other.partida)
				&& Objects.equals(plantilla, other.plantilla) && puntos == other.puntos
				&& Objects.equals(respuestaDada, other.respuestaDada) && tiempoMs == other.tiempoMs;
	}


	/**
	 * @return the idPartidaPregunta
	 */
	public Long getIdPartidaPregunta() {
		return idPartidaPregunta;
	}

	/**
	 * @param idPartidaPregunta the idPartidaPregunta to set
	 */
	public void setIdPartidaPregunta(Long idPartidaPregunta) {
		this.idPartidaPregunta = idPartidaPregunta;
	}

	/**
	 * @return the partida
	 */
	public Partida getPartida() {
		return partida;
	}

	/**
	 * @param partida the partida to set
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the plantilla
	 */
	public Plantilla getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * @return the respuestaDada
	 */
	public String getRespuestaDada() {
		return respuestaDada;
	}

	/**
	 * @param respuestaDada the respuestaDada to set
	 */
	public void setRespuestaDada(String respuestaDada) {
		this.respuestaDada = respuestaDada;
	}

	/**
	 * @return the correcta
	 */
	public boolean isCorrecta() {
		return correcta;
	}

	/**
	 * @param correcta the correcta to set
	 */
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * @return the tiempoMs
	 */
	public int getTiempoMs() {
		return tiempoMs;
	}

	/**
	 * @param tiempoMs the tiempoMs to set
	 */
	public void setTiempoMs(int tiempoMs) {
		this.tiempoMs = tiempoMs;
	}

	@Override
	public String toString() {
		return "PartidaPregunta [idPartidaPregunta=" + idPartidaPregunta + ", partida=" + partida + ", pais=" + pais
				+ ", plantilla=" + plantilla + ", respuestaDada=" + respuestaDada + ", correcta=" + correcta
				+ ", puntos=" + puntos + ", tiempoMs=" + tiempoMs + "]";
	}

    
    
    
}
 