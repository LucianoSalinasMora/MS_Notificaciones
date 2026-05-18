# MS_Notificaciones
Microservicio encargado de gestionar el envío y registro de notificaciones dirigidas a los estudiantes.
## Especificaciones Técnicas
* **Puerto:** `8009`
* **Base de Datos (Laragon):** `notificaciones_db`
* **Tecnologías:** Spring Boot 4.0.6

## Propósito
* Actuar como un log histórico de auditoría que guarda constancia de cada aviso emitido (como confirmaciones de toma de ramos o comprobantes de pago de arancel).

## Endpoints Principales
* `POST /api/v1/notificaciones` - Almacenar una alerta enviada (Canales: EMAIL, SMS, PUSH).
* `GET /api/v1/notificaciones/estudiante/{rut}` - Consultar buzón de alertas históricas del alumno.
