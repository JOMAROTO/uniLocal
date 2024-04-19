package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoNegocio;

import java.util.List;

public interface NegocioServicio {

    String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception;

    DetalleNegocioDTO obtenerNegocio(String idNegocio) throws Exception;

    void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception;

    void eliminarNegocio(String idNegocio) throws Exception;

    boolean existeNegocio(String idNegocio);

    void rechazarNegocio(String idNegocio) throws Exception;

    List<ItemNegocioDTO> buscarNegociosPorCategoria(CategoriaNegocio categoriaNegocio);

    List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre);

    List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio);

    List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception;

    void aprobarNegocio(String idNegocio) throws Exception;

}