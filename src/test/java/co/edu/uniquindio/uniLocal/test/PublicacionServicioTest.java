package co.edu.uniquindio.uniLocal.test;

import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.servicios.interfaces.PublicacionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class PublicacionServicioTest {
    @Autowired
    PublicacionServicio publicacionServicio;

    @Test
    public void agregarPublicacion() throws Exception {
        AgregarPublicacionDTO agregarPublicacionDTO = new AgregarPublicacionDTO(
                "Que bonito café",
                "imagen2",
                "Cliente1",
                LocalDateTime.now());
        Assertions.assertEquals("Que bonito café", publicacionServicio.obtenerPublicacion(publicacionServicio.agregarPublicacion(agregarPublicacionDTO)).descripcion());
    }

    @Test
    public void obtenerPublicacion() throws ResourceNotFoundException {
        Assertions.assertEquals("Me encanta la comida de aquí!", publicacionServicio.obtenerPublicacion("Publicacion3").descripcion());
    }

    @Test
    public void actualizarPublicacion() throws Exception {
        ActualizarPublicacionDTO actualizarPublicacionDTO = new ActualizarPublicacionDTO(
                "Publicacion1",
                "rutaimagenmodificada",
                "El mejor parche para tomar café con los amigos");
        Assertions.assertEquals("El mejor parche para tomar café con los amigos", publicacionServicio.obtenerPublicacion(publicacionServicio.actualizarPublicacion(actualizarPublicacionDTO)).descripcion());
    }

    @Test
    public void eliminarPublicacionTest() throws Exception {
        Assertions.assertThrows(Exception.class, () -> publicacionServicio.eliminarPublicacion("ASJDHASKDJAS"));
    }

}
