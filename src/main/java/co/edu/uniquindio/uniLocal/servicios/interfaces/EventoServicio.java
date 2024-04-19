package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.DetalleEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.ItemEventoDTO;

import java.util.List;

public interface EventoServicio {
    String agregarEvento(AgregarEventoDTO agregarEventoDTO) throws Exception;

    void actualizarEvento(ActualizarEventoDTO actualizarEventoDTO) throws Exception;

    void terminarEvento(String codigoEvento) throws Exception;

    List<ItemEventoDTO> listarEventosNegocio(String idNegocio) throws Exception;

    DetalleEventoDTO obtenerEvento(String idEvento) throws Exception;
}
