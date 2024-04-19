package co.edu.uniquindio.uniLocal.dto.clienteDTO;

public record CambioPasswordDTO(
        String passwordVieja,
        String passwordNueva,
        String id
) {
}