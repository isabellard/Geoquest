package co.edu.unbosque.geoquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.entity.Partida;
import co.edu.unbosque.geoquest.entity.PartidaPregunta;
import co.edu.unbosque.geoquest.repository.PartidaPreguntaRepository;

@Service
public class PartidaService implements CRUDOperation<Partida> {

	@Autowired
	private PartidaPreguntaRepository partidaPreguntaRepository;

	public boolean validarRespuesta(Long preguntaId, String respuestaUsuario) {
		PartidaPregunta pregunta = partidaPreguntaRepository.findById(preguntaId).get();

		String respuestaCorrecta = pregunta.getRespuestaDada();

		boolean esCorrecta = respuestaCorrecta.equals(respuestaUsuario);
		pregunta.setRespuestaDada(respuestaUsuario);
		pregunta.setCorrecta(esCorrecta);
		partidaPreguntaRepository.save(pregunta);
		return esCorrecta;
	}

	@Override
	public int create(Partida data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Partida> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Long id, Partida newData) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
