package co.edu.uniquindio.uniLocal.dto.clienteDTO;

import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DetalleClienteDTO(
        @NotBlank String id,
        @NotBlank String nombre,
        @NotBlank String fotoPerfil,
        @NotBlank String nickname,
        @NotBlank String email,
        @NotBlank String ciudadResidencia,
        List<String> listaFavoritos,
        EstadoRegistro estadoRegistro
) {
}
