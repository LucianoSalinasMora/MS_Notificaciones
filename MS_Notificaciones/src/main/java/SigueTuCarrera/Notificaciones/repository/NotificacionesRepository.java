package SigueTuCarrera.Notificaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SigueTuCarrera.Notificaciones.model.Notificaciones;

public interface NotificacionesRepository extends JpaRepository<Notificaciones, Long> {

}