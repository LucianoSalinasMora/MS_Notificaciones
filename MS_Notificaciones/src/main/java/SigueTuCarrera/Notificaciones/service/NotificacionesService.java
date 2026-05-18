package SigueTuCarrera.Notificaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SigueTuCarrera.Notificaciones.model.Notificaciones;
import SigueTuCarrera.Notificaciones.repository.NotificacionesRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificacionesService {

    @Autowired
    private NotificacionesRepository notificacionesRepository;

    public Notificaciones crearNotificacion(Notificaciones notificacion) {
        return notificacionesRepository.save(notificacion);
    }

    public List<Notificaciones> obtenerNotificaciones() {
        return notificacionesRepository.findAll();
    }

    public Optional<Notificaciones> obtenerNotificacion(Long notificacionId) {
        return notificacionesRepository.findById(notificacionId);
    }

    public Optional<Notificaciones> actualizarNotificacion(Long notificacionId, Notificaciones notificacionActualizada) {
        return notificacionesRepository.findById(notificacionId).map(existente -> {
            notificacionActualizada.setNotificacionId(notificacionId);
            return notificacionesRepository.save(notificacionActualizada);
        });
    }

    public boolean eliminarNotificacion(Long notificacionId) {
        if (notificacionesRepository.existsById(notificacionId)) {
            notificacionesRepository.deleteById(notificacionId);
            return true;
        }
        return false;
    }
}