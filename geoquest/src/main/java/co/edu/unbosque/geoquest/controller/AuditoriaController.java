package co.edu.unbosque.geoquest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.geoquest.entity.Auditoria;
import co.edu.unbosque.geoquest.service.AuditoriaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auditoria")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
@Tag(name = "Gestion de Auditoria", description = "Endpoints para gestión de auditoria")
@SecurityRequirement(name = "bearerAuth")
public class AuditoriaController {
	
	@Autowired
	public AuditoriaService auditoriaService; 
	
	public AuditoriaController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/getall")
	ResponseEntity<List<Auditoria>> getAuditoria() {
	    return new ResponseEntity<>(auditoriaService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/usuario")
	ResponseEntity<List<Auditoria>> getAuditoriaUsuario(@RequestParam String username) {
	    return new ResponseEntity<>(auditoriaService.getByUsuario(username), HttpStatus.OK);
	}

}
