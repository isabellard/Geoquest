package co.edu.unbosque.geoquest.dto;

import java.util.Objects;

import jakarta.persistence.*;

public class PartidaPreguntaDTO {
	
    private int idPartidaPregunta;
    private PartidaDTO partida;
    private PaisDTO pais;
    private PlantillaDTO plantilla;
    private String respuestaDada;
    private boolean correcta;
    private int puntos;
    private int tiempoMs;
    
    public PartidaPreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PartidaPreguntaDTO(PartidaDTO partida, PaisDTO pais, PlantillaDTO plantilla, String respuestaDada, boolean correcta,
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
		PartidaPreguntaDTO other = (PartidaPreguntaDTO) obj;
		return correcta == other.correcta && idPartidaPregunta == other.idPartidaPregunta
				&& Objects.equals(pais, other.pais) && Objects.equals(partida, other.partida)
				&& Objects.equals(plantilla, other.plantilla) && puntos == other.puntos
				&& Objects.equals(respuestaDada, other.respuestaDada) && tiempoMs == other.tiempoMs;
	}

	/**
	 * @return the idPartidaPregunta
	 */
	public int getIdPartidaPregunta() {
		return idPartidaPregunta;
	}

	/**
	 * @param idPartidaPregunta the idPartidaPregunta to set
	 */
	public void setIdPartidaPregunta(int idPartidaPregunta) {
		this.idPartidaPregunta = idPartidaPregunta;
	}

	/**
	 * @return the partida
	 */
	public PartidaDTO getPartida() {
		return partida;
	}

	/**
	 * @param partida the partida to set
	 */
	public void setPartida(PartidaDTO partida) {
		this.partida = partida;
	}

	/**
	 * @return the pais
	 */
	public PaisDTO getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	/**
	 * @return the plantilla
	 */
	public PlantillaDTO getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(PlantillaDTO plantilla) {
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
 