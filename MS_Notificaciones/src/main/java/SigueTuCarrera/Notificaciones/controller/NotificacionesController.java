package SigueTuCarrera.Notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SigueTuCarrera.Notificaciones.model.Notificaciones;
import SigueTuCarrera.Notificaciones.service.NotificacionesService;

@RestController
@RequestMapping("/api/v0/notificaciones")
public class NotificacionesController {

    @Autowired
    private NotificacionesService notificacionesService;

    
    @GetMapping
    public ResponseEntity<List<Notificaciones>> obtenerNotificaciones() {
        List<Notificaciones> notificaciones = notificacionesService.obtenerNotificaciones();
        if (notificaciones.isEmpty()) {
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.ok(notificaciones); //200
    }



    
    
    @PostMapping
    public ResponseEntity<Notificaciones> crearNotificacion(@RequestBody Notificaciones notificacion) {
        try {
            Notificaciones nueva = notificacionesService.crearNotificacion(notificacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nueva); //  201
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //    500
        }
    }

    
    @GetMapping("/{notificacionId}")
    public ResponseEntity<Notificaciones> obtenerNotificacion(@PathVariable Long notificacionId) {
        return notificacionesService.obtenerNotificacion(notificacionId)
                .map(n -> ResponseEntity.ok(n))           //200
                .orElse(ResponseEntity.notFound().build()); //     404
    }
    
    @PutMapping("/{notificacionId}")
    public ResponseEntity<Notificaciones> actualizarNotificacion(
            @PathVariable Long notificacionId,
            @RequestBody Notificaciones notificacion) {
        return notificacionesService.actualizarNotificacion(notificacionId, notificacion)
                .map(actualizada -> ResponseEntity.ok(actualizada))  // 200
                .orElse(ResponseEntity.notFound().build());          //    404
    }



    
    @DeleteMapping("/{notificacionId}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long notificacionId) {
        if (notificacionesService.eliminarNotificacion(notificacionId)) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.notFound().build(); //404
    }
}