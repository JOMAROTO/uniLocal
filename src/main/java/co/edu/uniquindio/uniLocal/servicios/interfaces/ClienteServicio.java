package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.clienteDTO.*;

import java.util.List;

public interface ClienteServicio {

    String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception;

    void editarPerfil(ActualizarClienteDTO actualizarClienteDTO) throws Exception;

    void eliminarCliente(String idCuenta) throws Exception;

    DetalleClienteDTO obtenerCliente(String idCliente) throws Exception;

    boolean existeCliente(String idCliente);

    List<ItemClienteDTO> listarClientes();

    String agregarNegocioFavorito(AgregarNegocioFavoritosDTO agregarNegocioFavoritosDTO) throws Exception;

    void cambiarPassword(CambioPasswordDTO cambioPasswordDTO) throws Exception;
}