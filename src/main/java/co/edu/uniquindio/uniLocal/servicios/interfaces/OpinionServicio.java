package co.edu.uniquindio.uniLocal.servicios.interfaces;

import co.edu.uniquindio.uniLocal.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.opinionDTO.ReaccionarOpinionDTO;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;

import java.util.List;

public interface OpinionServicio {
    String opinarPublicacion(OpinarPublicacionDTO opinarPublicacionDTO) throws Exception;

    List<ItemOpinionDTO> listarOpinionesPublicacion(String idPublicacion) throws ResourceNotFoundException;

    void reaccionarOpinion(ReaccionarOpinionDTO reaccionarOpinionDTO) throws Exception;

    List<ItemOpinionDTO> listarOpinionesCliente(String idCliente) throws Exception;
}
