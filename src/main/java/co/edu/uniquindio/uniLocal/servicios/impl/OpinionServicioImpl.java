package co.edu.uniquindio.uniLocal.servicios.impl;

import co.edu.uniquindio.uniLocal.dto.emailDTO.EmailDTO;
import co.edu.uniquindio.uniLocal.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal.dto.opinionDTO.OpinarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.opinionDTO.ReaccionarOpinionDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Opinion;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.repositorios.OpinionRepo;
import co.edu.uniquindio.uniLocal.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.OpinionServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.PublicacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OpinionServicioImpl implements OpinionServicio {

    private final OpinionRepo opinionRepo;
    private final ClienteServicio clienteServicio;
    private final PublicacionServicio publicacionServicio;
    private final EmailServicio emailServicio;

    @Override
    public String opinarPublicacion(OpinarPublicacionDTO opinarPublicacionDTO) throws Exception {

        if (!publicacionServicio.existePublicacion(opinarPublicacionDTO.codigoPublicacion())) {
            throw new ResourceNotFoundException(opinarPublicacionDTO.codigoPublicacion());
        }

        if (!clienteServicio.existeCliente(opinarPublicacionDTO.codigoCliente())) {
            throw new ResourceNotFoundException(opinarPublicacionDTO.codigoCliente());
        }

        Opinion opinion = new Opinion();

        opinion.setCodigoPublicacion(opinarPublicacionDTO.codigoPublicacion());
        opinion.setCodigoCliente(opinarPublicacionDTO.codigoCliente());
        opinion.setFecha(LocalDateTime.now());
        opinion.setMensaje(opinarPublicacionDTO.mensaje());

        Opinion opinionGuardada = opinionRepo.save(opinion);

        //Codigo de enviar correos de prueba
        emailServicio.enviarCorreo(new EmailDTO(
                "Tu publicación ha sido comentada",
                "Tu publicación ha sido comentada por " + clienteServicio.obtenerCliente(opinarPublicacionDTO.codigoCliente()).nickname() + ": " + opinarPublicacionDTO.mensaje(),
                clienteServicio.obtenerCliente(
                        publicacionServicio.obtenerPublicacion(opinarPublicacionDTO.codigoPublicacion()).codigoCliente()
                ).email()
        ));

        return opinionGuardada.getCodigoOpinion();
    }

    @Override
    public List<ItemOpinionDTO> listarOpinionesPublicacion(String idPublicacion) throws ResourceNotFoundException {
        return opinionRepo.findAllByCodigoPublicacion(idPublicacion);
    }

    @Override
    public void reaccionarOpinion(ReaccionarOpinionDTO reaccionarOpinionDTO) throws Exception {

        if (!clienteServicio.existeCliente(reaccionarOpinionDTO.idCliente())) {
            throw new ResourceNotFoundException(reaccionarOpinionDTO.idCliente());
        }

        Opinion opinion = obtenerOpinionID(reaccionarOpinionDTO.idOpinion());

        if (opinion.getListaMeGustas().contains(reaccionarOpinionDTO.idCliente())) {
            opinion.getListaMeGustas().remove(reaccionarOpinionDTO.idCliente());
        } else {
            opinion.getListaMeGustas().add(reaccionarOpinionDTO.idCliente());
        }

        opinionRepo.save(opinion);
    }

    @Override
    public List<ItemOpinionDTO> listarOpinionesCliente(String idCliente) throws Exception {
        return opinionRepo.findAllByCodigoCliente(idCliente);
    }

    //Metodos para verificar existencia de datos
    private Opinion obtenerOpinionID(String idOpinion) throws ResourceNotFoundException {

        Optional<Opinion> optionalOpinion = opinionRepo.findById(idOpinion);

        if (optionalOpinion.isEmpty()) {
            throw new ResourceNotFoundException(idOpinion);
        }

        return optionalOpinion.get();
    }
}
