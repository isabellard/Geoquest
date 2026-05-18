package co.edu.unbosque.geoquest.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.entity.Auditoria;
import co.edu.unbosque.geoquest.entity.Usuario;
import co.edu.unbosque.geoquest.repository.AuditoriaRepository;
import co.edu.unbosque.geoquest.repository.UsuarioRepository;

@Service
public class AuditoriaService {

	@Autowired
	private AuditoriaRepository auditoriaRepo;

	@Autowired
	private UsuarioRepository userRepo;


	public AuditoriaService() {
		// TODO Auto-generated constructor stub
	}

	public void registrar(String username, Auditoria.TipoAccion tipo, String detalle) {
		Usuario usuario = userRepo.findBynombreUsuario(username).get(); 
		auditoriaRepo.save(new Auditoria(usuario, tipo, detalle));
	}

	public List<Auditoria> getAll() {
		return auditoriaRepo.findAllByOrderByFechaDesc();
	}

	public List<Auditoria> getByUsuario(String username) {
		Usuario usuario = userRepo.findBynombreUsuario(username).get(); 
		return auditoriaRepo.getByUsuarioOrderByFechaDesc(usuario);
	}
}