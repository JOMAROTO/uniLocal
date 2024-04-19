package co.edu.uniquindio.uniLocal.modelo.documentos;

import co.edu.uniquindio.uniLocal.modelo.Horario;
import co.edu.uniquindio.uniLocal.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("negocios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Negocio {
    @Id
    @EqualsAndHashCode.Include
    private String codigoNegocio;

    private String codigoCliente;
    private String nombre;
    private String descripcion;
    private CategoriaNegocio categoriaNegocio;
    private EstadoNegocio estadoNegocio;
    private Ubicacion ubicacion;
    private List<String> listaTelefonos = new ArrayList<>();
    private List<String> listaRutasImagenes = new ArrayList<>();
    private List<Horario> listaHorarios = new ArrayList<>();
    private EstadoRegistro estadoRegistro;

}
