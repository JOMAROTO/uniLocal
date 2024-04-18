package co.edu.uniquindio.uniLocal.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document("comentarios")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String codigo;
    private LocalDateTime fecha;
    private String codigoCliente;
    private String codigoNegocio;
    private String mensaje;
    private String respuesta;




}
