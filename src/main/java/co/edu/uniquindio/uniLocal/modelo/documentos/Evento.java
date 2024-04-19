package co.edu.uniquindio.uniLocal.modelo.documentos;

import co.edu.uniquindio.uniLocal.modelo.Horario;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.TipoEvento;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Evento {
    @Id
    @EqualsAndHashCode.Include
    private String codigoEvento;
    private String codigoNegocio;

    private String nombre;
    private String descripcion;
    private TipoEvento tipoEvento;
    private List<Horario> diasDisponible;
    private EstadoEvento estadoEvento;
}
