package co.edu.uniquindio.uniLocal.dto.negocioDTO;

import co.edu.uniquindio.uniLocal.modelo.Horario;
import co.edu.uniquindio.uniLocal.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import jakarta.validation.constraints.*;

import java.util.List;

public record ItemNegocioDTO(
        @NotBlank String codigoNegocio,
        @NotBlank String codigoCliente,
        @NotBlank @Min(10) @Max(50) String nombre,
        @NotBlank @Min(50) @Max(300) String descripcion,
        @NotNull CategoriaNegocio categoriaNegocio,
        @NotNull EstadoNegocio estadoNegocio,
        @NotNull Ubicacion ubicacion,
        List<String> listaTelefonos,
        @NotEmpty List<String> listaRutasImagenes,
        @NotEmpty List<Horario> listaHorarios,
        @NotNull EstadoRegistro estadoRegistro
) {
}
