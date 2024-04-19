package co.edu.uniquindio.uniLocal.test;

import co.edu.uniquindio.uniLocal.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal.modelo.Horario;
import co.edu.uniquindio.uniLocal.modelo.Ubicacion;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.NegocioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NegocioServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private NegocioServicio negocioServicio;

    @Test
    public void agregarNegocioTest() throws Exception {
        List<String> listaImagenesNegocio = new ArrayList<>();
        listaImagenesNegocio.add("rutaimagennegocio1");

        List<String> listaTelefonos = new ArrayList<>();
        listaTelefonos.add("3091238764");

        List<Horario> listaHorarios = new ArrayList<>();
        listaHorarios.add(new Horario("7:00", "22:00", "MIERCOLES"));

        Ubicacion ubicacion = new Ubicacion(10.023, -65.2138);

        AgregarNegocioDTO agregarNegocioDTO = new AgregarNegocioDTO(
                "Cliente1",
                "Restaurante Mexicano el chilito",
                "Restaurante de comida mexicana en Armnia",
                CategoriaNegocio.RESTAURANTE,
                listaImagenesNegocio,
                listaTelefonos,
                listaHorarios,
                ubicacion);

        String codigoNegocio = negocioServicio.agregarNegocio(agregarNegocioDTO);
        Assertions.assertEquals("Restaurante Mexicano el chilito", negocioServicio.obtenerNegocio(codigoNegocio).nombre());
    }

    @Test
    public void actualizarNegocioTest() throws Exception {
        List<String> listaImagenesNegocio = new ArrayList<>();
        listaImagenesNegocio.add("rutaimagennegocio1");

        List<String> listaTelefonos = new ArrayList<>();
        listaTelefonos.add("3091238764");

        List<Horario> listaHorarios = new ArrayList<>();
        listaHorarios.add(new Horario("7:00", "22:00", "MIERCOLES"));

        Ubicacion ubicacion = new Ubicacion(10.023, -65.2138);

        ActualizarNegocioDTO actualizarNegocioDTO = new ActualizarNegocioDTO(
                "Negocio3",
                "Ferreteria los milagros",
                "Ferreteria ubicada en el barrio los milagros",
                CategoriaNegocio.FERRETERIA,
                listaImagenesNegocio,
                listaTelefonos,
                listaHorarios,
                ubicacion);

        negocioServicio.actualizarNegocio(actualizarNegocioDTO);
        Assertions.assertEquals("Ferreteria los milagros", negocioServicio.obtenerNegocio(actualizarNegocioDTO.codigoNegocio()).nombre());

    }

    @Test
    public void eliminarNegocioTest() throws Exception {
        negocioServicio.eliminarNegocio("Negocio4");
        Assertions.assertEquals(EstadoRegistro.INACTIVO, negocioServicio.obtenerNegocio("Negocio4").estadoRegistro());
    }

    @Test
    public void rechazarNegocioTest() throws Exception {
        negocioServicio.rechazarNegocio("Negocio4");
        Assertions.assertEquals(EstadoNegocio.RECHAZADO, negocioServicio.obtenerNegocio("Negocio4").estadoNegocio());
    }

    @Test
    public void aprobarNegocioTest() throws Exception {
        negocioServicio.aprobarNegocio("Negocio2");
        Assertions.assertEquals(EstadoNegocio.APROBADO, negocioServicio.obtenerNegocio("Negocio4").estadoNegocio());
    }

    @Test
    public void obtenerNegocioTest() throws Exception {
        Assertions.assertEquals("Tecnologic S.A.S", negocioServicio.obtenerNegocio("Negocio4").nombre());

    }

    @Test
    public void buscarNegociosPorCategoriaTest() {
        List<ItemNegocioDTO> listaNegocios = negocioServicio.buscarNegociosPorCategoria(CategoriaNegocio.CAFETERIA);
        Assertions.assertEquals(1, listaNegocios.size());
    }

    @Test
    public void buscarNegociosPorNombreSimilarTest() {
        List<ItemNegocioDTO> listaNegocios = negocioServicio.buscarNegociosPorNombreSimilar("cafeteria");
        Assertions.assertEquals(1, listaNegocios.size());
    }

    @Test
    public void filtrarPorEstadoTest() {
        Assertions.assertEquals(1, negocioServicio.filtrarPorEstado(EstadoNegocio.APROBADO).size());
    }

    @Test
    public void listarNegociosPropietarioTest() throws Exception {
        Assertions.assertEquals(3, negocioServicio.listarNegociosPropietario("Cliente1").size());
    }

    @Test
    public void existeNegocio() {
        Assertions.assertFalse(negocioServicio.existeNegocio("Negocio10231823"));
    }


}
