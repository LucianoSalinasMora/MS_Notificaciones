package SigueTuCarrera.Notificaciones.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificacionId;
    
    private String estudianteId;
    private String titulo;
    
    @Column(columnDefinition = "TEXT")
    private String mensaje;
    
    private LocalDateTime fechaEnvio;
    private Boolean leido = false; // x defecto
    
    @Enumerated(EnumType.STRING)
    private Canal canal;

    public enum Canal {
        EMAIL, SMS, PUSH_NOTIFICATION
    }
}
