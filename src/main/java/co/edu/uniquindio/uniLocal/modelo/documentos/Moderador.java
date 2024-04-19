package co.edu.uniquindio.uniLocal.modelo.documentos;

import co.edu.uniquindio.uniLocal.modelo.Cuenta;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("moderadores")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Moderador extends Cuenta {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    public Moderador(String nombre, String fotoPerfil, String password, String email, EstadoRegistro estadoRegistro) {
        super(nombre, fotoPerfil, password, email, estadoRegistro);
    }
}
