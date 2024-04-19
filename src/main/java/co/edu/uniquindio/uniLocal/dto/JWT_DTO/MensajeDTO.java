package co.edu.uniquindio.uniLocal.dto.JWT_DTO;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}