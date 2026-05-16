package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.dto.PaisDTO;
import co.edu.unbosque.geoquest.entity.Pais;
import co.edu.unbosque.geoquest.repository.PaisRepository;
import jakarta.transaction.Transactional;

@Service
public class PaisService implements CRUDOperation<PaisDTO> {

	@Autowired
	private PaisRepository paisRepo;

	@Autowired
	private ModelMapper modelMapper;

	private Random random;

	public PaisService() {
		random = new Random();
	}

	public PaisDTO seleccionaPaiseSegunDificultad(int dificultad) {
		Short popularidadMaxima;
		switch (dificultad) {
		case 1:
			popularidadMaxima = 5;
			break;
		case 2:
			popularidadMaxima = 30;
			break;
		case 3:
			popularidadMaxima = 75;
			break;
		default:
			popularidadMaxima = 75;
		}
		List<Pais> entityList = paisRepo.findByPopularidad(popularidadMaxima);
		PaisDTO paisElegido = modelMapper.map(entityList.get(random.nextInt(0, entityList.size() - 1)), PaisDTO.class);

		return paisElegido;
	}

	@Transactional
	public List<Pais> findByPopularidad(short dificultad) {
		return paisRepo.findByPopularidad(dificultad);
	}

	public PaisDTO findById(Long id) {
		return modelMapper.map(paisRepo.findById(id).get(), PaisDTO.class);
	}

	@Override
	public int create(PaisDTO data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PaisDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Long id, PaisDTO newData) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long count() {
		return paisRepo.count();
	}

	@Override
	public boolean exist(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
