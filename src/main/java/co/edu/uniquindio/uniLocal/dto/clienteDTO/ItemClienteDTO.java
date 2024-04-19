package co.edu.uniquindio.uniLocal.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ItemClienteDTO(
        @NotBlank String codigo,
        @NotBlank String nombre,
        @NotBlank String fotoPerfil,
        @NotBlank String nickname,
        @NotBlank String email,
        @NotBlank String ciudadResidencia,
        List<String> listaNegociosFavoritos
) {
}
