package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ItemPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ReaccionarPublicacionDTO;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;

public interface PublicacionServicio {
    String agregarPublicacion(AgregarPublicacionDTO agregarPublicacionDTO) throws Exception;

    String actualizarPublicacion(ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception;

    void eliminarPublicacion(String idPublicacion) throws Exception;

    ItemPublicacionDTO obtenerPublicacion(String idPublicacion) throws ResourceNotFoundException;

    boolean existePublicacion(String idPublicacion);

    void reaccionarPublicacion(ReaccionarPublicacionDTO reaccionarPublicacionDTO) throws Exception;
}
