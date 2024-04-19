package co.edu.uniquindio.uniLocal.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;

public record AgregarNegocioFavoritosDTO(
        @NotBlank String idCliente,
        @NotBlank String idNegocio
) {
}
