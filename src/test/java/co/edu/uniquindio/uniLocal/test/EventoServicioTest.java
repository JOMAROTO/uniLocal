package co.edu.uniquindio.uniLocal.test;

import co.edu.uniquindio.uniLocal.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal.modelo.Horario;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.TipoEvento;
import co.edu.uniquindio.uniLocal.servicios.interfaces.EventoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EventoServicioTest {
    @Autowired
    EventoServicio eventoServicio;

    @Test
    public void agregarEventoTest() throws Exception {
        List<Horario> listaHorarios = new ArrayList<>();
        Horario horario = new Horario("9:00", "15:00", "VIERNES");
        listaHorarios.add(horario);
        AgregarEventoDTO agregarEventoDTO = new AgregarEventoDTO(
                "Negocio1",
                listaHorarios,
                "La prueba del café",
                "Venga a probar todos los tipos de café",
                TipoEvento.SOCIAL);
        Assertions.assertEquals("La prueba del café", eventoServicio.obtenerEvento(eventoServicio.agregarEvento(agregarEventoDTO)).nombre());
    }

    @Test
    public void actualizarEventoTest() throws Exception {
        List<Horario> listaHorario = new ArrayList<>();
        listaHorario.add(new Horario("8:00", "16:00", "JUEVES"));
        ActualizarEventoDTO actualizarEventoDTO = new ActualizarEventoDTO(
                "Evento1",
                listaHorario,
                "Feria del café",
                "Ven a probar todos los tipos de ca´fe de todo el mundo",
                TipoEvento.CULTURAL);
        eventoServicio.actualizarEvento(actualizarEventoDTO);
        Assertions.assertEquals("Feria del café", eventoServicio.obtenerEvento("Evento1").nombre());
    }

    @Test
    public void terminarEventoTest() throws Exception {
        eventoServicio.terminarEvento("Evento1");
        int bandera = EstadoEvento.FINALIZADO.compareTo(eventoServicio.obtenerEvento("Evento1").estadoEvento());
        Assertions.assertEquals(bandera, 0);
    }

    @Test
    public void listarEventosNegocioTest() throws Exception {
        List<ItemEventoDTO> listaEventos = eventoServicio.listarEventosNegocio("Negocio1");
        Assertions.assertEquals(2, listaEventos.size());
    }
}
