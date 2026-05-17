package co.edu.unbosque.geoquest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

	private List<Pais> paises;

	public PaisService() {
		random = new Random();
	}

	public PaisDTO seleccionaPaiseSegunDificultad(int dificultad) {
		short maxPop = (short) (dificultad == 1 ? 5 : dificultad == 2 ? 30 : 75);
		List<Pais> filtrados = getPaisesEntidad().stream().filter(p -> p.getPopularidad() <= maxPop)
				.collect(Collectors.toList());
		return toPaisDTO(filtrados.get(random.nextInt(filtrados.size())));
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
		List<Pais> entityList = paisRepo.findAll();
		List<PaisDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {

			PaisDTO dto = modelMapper.map(entity, PaisDTO.class);
			dtoList.add(dto);
		});

		return dtoList;
	}

	public List<Pais> getPaisesEntidad() {
		if (paises == null || paises.isEmpty()) {
			paises = paisRepo.findAll(); // sin ModelMapper
		}
		return paises;
	}

	public PaisDTO toPaisDTO(Pais pais) {
		return modelMapper.map(pais, PaisDTO.class);
	}

	public PaisDTO getPaisRandom() {
		List<Pais> paises = getPaisesEntidad();
		return toPaisDTO(paises.get(random.nextInt(paises.size())));
	}

	public PaisDTO getPaisDistinto(Long idExcluir) {
		List<Pais> paises = getPaisesEntidad().stream().filter(p -> !p.getIdPais().equals(idExcluir))
				.collect(Collectors.toList());
		return toPaisDTO(paises.get(random.nextInt(paises.size())));
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
