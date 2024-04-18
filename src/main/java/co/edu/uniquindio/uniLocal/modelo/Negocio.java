package co.edu.uniquindio.uniLocal.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("negocios")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Negocio {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private Ubicacion ubicacion;
    private String nombre;
    private String descripcion;
    private List<Horario> horarios;
    private EstadoRegistro estado;
    private List<String> imagenes;
    private String codigoCliente;
    private TipoNegocio tipoNegocio;
    private List<String> telefonos;
    private List<HistorialRevision> historialRevisiones;
}
