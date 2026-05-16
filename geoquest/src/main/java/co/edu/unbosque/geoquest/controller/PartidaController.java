package co.edu.unbosque.geoquest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.geoquest.dto.PartidaDTO;
import co.edu.unbosque.geoquest.service.PartidaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/partida")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081" })
@Transactional
@Tag(name = "Gestion de partidas", description = "Endpoints para gestión de partidas")
@SecurityRequirement(name = "bearerAuth")
public class PartidaController {

	@Autowired
	public PartidaService partSer;

	public PartidaController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/iniciardificultad")
	ResponseEntity<PartidaDTO> getPartidaDificultad(@RequestParam int dificultad, @RequestParam String username) {
		PartidaDTO partidaDTO = partSer.iniciarDificultad(dificultad, username);
		if (partidaDTO != null) {
			return new ResponseEntity<>(partidaDTO, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new PartidaDTO(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/iniciarCategoria")
	ResponseEntity<PartidaDTO> getPartidaDificultad(@RequestParam Long categoria, @RequestParam String username) {
		PartidaDTO partidaDTO = partSer.iniciarCategoria(categoria, username);
		if (partidaDTO != null) {
			return new ResponseEntity<>(partidaDTO, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(new PartidaDTO(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/update")
	ResponseEntity<String> updateNew(@RequestParam long id, @RequestParam int respuestaCorrecta,
			@RequestParam int puntos) {
		int status = partSer.updatePartida(id, respuestaCorrecta, puntos); 

		if (status == 1) {
			return new ResponseEntity<>("Partida updated successfully", HttpStatus.ACCEPTED);
		} else if (status == 2) {
			return new ResponseEntity<>("Partida not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}

}
