package co.edu.uniquindio.uniLocal.test;

import co.edu.uniquindio.uniLocal.dto.calificacionDTO.ActualizarCalificacionDTO;
import co.edu.uniquindio.uniLocal.dto.calificacionDTO.AgregarCalificacionDTO;
import co.edu.uniquindio.uniLocal.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal.dto.calificacionDTO.ResponderCalificacionDTO;
import co.edu.uniquindio.uniLocal.servicios.interfaces.CalificacionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class CalificacionServicioTest {

    @Autowired
    CalificacionServicio calificacionServicio;

    @Test
    public void agregarCalificacionTest() throws Exception {
        //Cliente 2 es un cliente inactivo
        AgregarCalificacionDTO agregarCalificacionDTO = new AgregarCalificacionDTO(
                "Cliente2", "Negocio4", LocalDateTime.now(),
                5, "Excelente");
        Assertions.assertThrows(Exception.class, () -> calificacionServicio.agregarCalificacion(agregarCalificacionDTO));
    }

    @Test
    public void actualizarCalificacionTest() throws Exception {
        ActualizarCalificacionDTO actualizarCalificacionDTO = new ActualizarCalificacionDTO(
                "Calificacion3", 3, "Volví y subieron demasiado los precios");
        calificacionServicio.actualizarCalificacion(actualizarCalificacionDTO);
        Assertions.assertEquals("Volví y subieron demasiado los precios", calificacionServicio.obtenerCalificacion("Calificacion3").mensaje());
    }

    @Test
    public void listarCalificacionesNegocioTest() throws Exception {
        //Solo hay 3 calificaciones para negocio1
        List<ItemCalificacionDTO> listaItemCalificacionDTO = calificacionServicio.listarCalificacionesNegocio("Negocio1");
        Assertions.assertEquals(2, listaItemCalificacionDTO.size());
    }

    @Test
    public void responderCalificacionTest() throws Exception {
        ResponderCalificacionDTO responderCalificacionDTO = new ResponderCalificacionDTO(
                "Calificacion1",
                "Gracias! Eres bienvenido");
        calificacionServicio.responderCalificacion(responderCalificacionDTO);
        Assertions.assertEquals("Gracias! Eres bienvenido", calificacionServicio.obtenerCalificacion("Calificacion1").respuesta());
    }

    @Test
    public void obtenerCalificacionPromedioNegocioTest() {
        Assertions.assertEquals(4, calificacionServicio.obtenerCalificacionPromedioNegocio("Negocio1"));
    }
}
