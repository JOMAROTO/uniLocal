package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.moderadorDTO.ActualizarModeradorDTO;

public interface ModeradorServicio {
    void actualizarModerador(ActualizarModeradorDTO actualizarModeradorDTO) throws Exception;

    boolean existeModerador(String codigoModerador);
}
