package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.JWT_DTO.TokenDTO;
import co.edu.uniquindio.uniLocal.dto.LoginDTO.LoginDTO;

public interface AutenticacionServicio {

    TokenDTO iniciarSesionCliente(LoginDTO loginDTO) throws Exception;

    TokenDTO iniciarSesionModerador(LoginDTO loginDTO) throws Exception;
}
