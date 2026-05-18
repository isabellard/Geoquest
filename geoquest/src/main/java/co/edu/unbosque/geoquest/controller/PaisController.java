package co.edu.unbosque.geoquest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.geoquest.entity.Pais;
import co.edu.unbosque.geoquest.service.PaisService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pais")
@Transactional
@Tag(name = "Gestion de paises", description = "Endpoints para gestión de paises")
@SecurityRequirement(name = "bearerAuth")
public class PaisController {

	@Autowired
	public PaisService paisser;

	public PaisController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/paises")
	ResponseEntity<List<Pais>> getRanking(@RequestParam short dificultad) {
		List<Pais> partidaDTO = paisser.findByPopularidad(dificultad);
		if (partidaDTO != null) {
			return new ResponseEntity<>(partidaDTO, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(partidaDTO, HttpStatus.NOT_FOUND);
		}
	}

}
