package co.edu.unbosque.geoquest.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.geoquest.dto.PlantillaDTO;
import co.edu.unbosque.geoquest.repository.PlantillaRepository;

@Service
public class PlantillaService implements CRUDOperation<PlantillaDTO> {

	@Autowired
	private PlantillaRepository plantillaRepo;

	@Autowired
	private ModelMapper modelMapper;

	private Random random;

	private List<PlantillaDTO> PlantillasTodas;
	private List<PlantillaDTO> PlantillasCategoria;
	private Long ultimaCategoria;

	public PlantillaService() {
		random = new Random();
	}

	public List<PlantillaDTO> getTodasPlantillas() {
		if (PlantillasTodas == null) {
			PlantillasTodas = plantillaRepo.findAll().stream().map(p -> modelMapper.map(p, PlantillaDTO.class))
					.collect(Collectors.toList());
		}
		return PlantillasTodas;
	}

	public PlantillaDTO findById(Long id) {
		return getTodasPlantillas().stream().filter(p -> p.getIdPlantilla().equals(id)).findFirst().orElse(null);
	}

	public PlantillaDTO plantillaCategoria(Long categoria) {
		if (PlantillasCategoria == null || !categoria.equals(ultimaCategoria)) {
			ultimaCategoria = categoria;
			PlantillasCategoria = getTodasPlantillas().stream()
					.filter(p -> p.getCategoria().getIdCategoria().equals(categoria)).collect(Collectors.toList());
		}
		return PlantillasCategoria.get(random.nextInt(PlantillasCategoria.size()));
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

	@Override
	public int create(PlantillaDTO data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlantillaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Long id, PlantillaDTO newData) {
		// TODO Auto-generated method stub
		return 0;
	}

}
