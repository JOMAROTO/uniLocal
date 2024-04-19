package co.edu.uniquindio.uniLocal.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Horario {
    private String horaApertura;
    private String horaCierre;
    private String diaSemana;
}
