package co.edu.uniquindio.uniLocal.dto.negocioDTO;

import co.edu.uniquindio.uniLocal.modelo.Horario;
import co.edu.uniquindio.uniLocal.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import jakarta.validation.constraints.*;

import java.util.List;

public record AgregarNegocioDTO(
        @NotBlank String codigoCliente,
        @NotBlank @Min(10) @Max(50) String nombreNegocio,
        @NotBlank @Min(50) @Max(300) String descripcion,
        @NotNull CategoriaNegocio categoriaNegocio,

        //Revisar lo de la lista de imagenes de negocio
        @NotEmpty List<String> listaImagenesNegocio,
        //Revisar lo de lista de telefonos
        List<String> listaTelefonos,
        //Revisar lo de horarios
        @NotEmpty List<Horario> listaHorarios,
        @NotNull Ubicacion ubicacion
) {
}
