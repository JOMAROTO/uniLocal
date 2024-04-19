package co.edu.uniquindio.uniLocal.servicios.impl;

import co.edu.uniquindio.uniLocal.dto.eventoDTO.ActualizarEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.AgregarEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.DetalleEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Evento;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoEvento;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.repositorios.EventoRepo;
import co.edu.uniquindio.uniLocal.servicios.interfaces.EventoServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.NegocioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoServicioImpl implements EventoServicio {

    private final EventoRepo eventoRepo;
    private final NegocioServicio negocioServicio;

    @Override
    public String agregarEvento(AgregarEventoDTO agregarEventoDTO) throws Exception {

        if (!negocioServicio.existeNegocio(agregarEventoDTO.idNegocio())){
            throw new Exception("El negocio no existe");
        }
        if (negocioServicio.obtenerNegocio(agregarEventoDTO.idNegocio()).estadoRegistro() == EstadoRegistro.INACTIVO){
            throw new Exception("El negocio está inactivo");
        }
        Evento evento = new Evento();

        evento.setNombre(agregarEventoDTO.nombre());
        evento.setDescripcion(agregarEventoDTO.descripcion());
        evento.setTipoEvento(agregarEventoDTO.tipoEvento());
        evento.setDiasDisponible(agregarEventoDTO.horario());
        evento.setEstadoEvento(EstadoEvento.EN_CURSO);
        evento.setCodigoNegocio(agregarEventoDTO.idNegocio());

        Evento eventoGuardado = eventoRepo.save(evento);
        return eventoGuardado.getCodigoEvento();
    }

    @Override
    public void actualizarEvento(ActualizarEventoDTO actualizarEventoDTO) throws Exception {

        Evento evento = obtenerEventoID(actualizarEventoDTO.codigoEvento());

        evento.setNombre(actualizarEventoDTO.nombre());
        evento.setDescripcion(actualizarEventoDTO.descripcion());
        evento.setTipoEvento(actualizarEventoDTO.tipoEvento());
        evento.setDiasDisponible(actualizarEventoDTO.horario());

        eventoRepo.save(evento);
    }

    @Override
    public void terminarEvento(String codigoEvento) throws Exception {
        Evento evento = obtenerEventoID(codigoEvento);
        if (evento.getEstadoEvento() == EstadoEvento.FINALIZADO) {
            throw new Exception("El evento ya ha sido finalizado");
        }
        evento.setEstadoEvento(EstadoEvento.FINALIZADO);

        eventoRepo.save(evento);
    }

    @Override
    public List<ItemEventoDTO> listarEventosNegocio(String idNegocio) throws Exception {
        List<Evento> listaEventos = eventoRepo.findAllByCodigoNegocio(idNegocio);
        List<ItemEventoDTO> itemsEventoDTO = new ArrayList<>();
        for (Evento evento : listaEventos) {
            itemsEventoDTO.add(new ItemEventoDTO(
                    evento.getCodigoEvento(),
                    evento.getCodigoNegocio(),
                    evento.getNombre(),
                    evento.getDescripcion(),
                    evento.getTipoEvento(),
                    evento.getDiasDisponible(),
                    evento.getEstadoEvento()
            ));
        }
        return itemsEventoDTO;
    }

    @Override
    public DetalleEventoDTO obtenerEvento(String idEvento) throws Exception {
        Evento evento = obtenerEventoID(idEvento);
        return new DetalleEventoDTO(
                evento.getCodigoEvento(),
                evento.getCodigoNegocio(),
                evento.getNombre(),
                evento.getDescripcion(),
                evento.getTipoEvento(),
                evento.getDiasDisponible(),
                evento.getEstadoEvento()
        );
    }

    private Evento obtenerEventoID(String idEvento) throws ResourceNotFoundException {

        Optional<Evento> optionalEvento = eventoRepo.findById(idEvento);

        if (optionalEvento.isEmpty()) {
            throw new ResourceNotFoundException(idEvento);
        }

        return optionalEvento.get();
    }

    private boolean existeEvento(String idEvento) {
        return eventoRepo.findById(idEvento).isPresent();
    }
}
