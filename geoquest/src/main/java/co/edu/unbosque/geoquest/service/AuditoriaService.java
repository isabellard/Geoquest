package co.edu.unbosque.geoquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.geoquest.entity.Auditoria;
import co.edu.unbosque.geoquest.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepo;

    public void registrar(String username, Auditoria.TipoAccion tipo, String detalle) {
        auditoriaRepo.save(new Auditoria(username, tipo, detalle));
    }

    public List<Auditoria> getAll() {
        return auditoriaRepo.findAllByOrderByFechaDesc();
    }

    public List<Auditoria> getByUsuario(String username) {
        return auditoriaRepo.findByNombreUsuarioOrderByFechaDesc(username);
    }
}