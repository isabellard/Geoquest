package co.edu.unbosque.geoquest.service;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.geoquest.dto.PlantillaDTO;
import co.edu.unbosque.geoquest.entity.Categoria;
import co.edu.unbosque.geoquest.repository.CategoriaRepository;
import co.edu.unbosque.geoquest.repository.PlantillaRepository;

@Service
public class PlantillaService implements CRUDOperation<PlantillaDTO> {

	@Autowired
	private PlantillaRepository plantillaRepo;

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private ModelMapper modelMapper;

	private Random random;

	public PlantillaService() {
		random = new Random();
	}

	public PlantillaDTO findById(Long id) {
		return modelMapper.map(plantillaRepo.findById(id).get(), PlantillaDTO.class);
	}

	public PlantillaDTO plantillaCategoria(Long categoria) {
		PlantillaDTO plantilla = modelMapper.map(findById(random.nextLong(1, 17)), PlantillaDTO.class);
		while (plantilla.getCategoria().getIdCategoria() != categoria) {
			plantilla = modelMapper.map(findById(random.nextLong(1, 17)), PlantillaDTO.class);
		}
		return plantilla; 

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
