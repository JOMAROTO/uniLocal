package co.edu.uniquindio.uniLocal.servicios.impl;

import co.edu.uniquindio.uniLocal.dto.calificacionDTO.*;
import co.edu.uniquindio.uniLocal.dto.emailDTO.EmailDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Calificacion;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.repositorios.CalificacionRepo;
import co.edu.uniquindio.uniLocal.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.EmailServicio;
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
public class CalificacionServicioImpl implements CalificacionServicio {

    private final CalificacionRepo calificacionRepo;
    private final NegocioServicio negocioServicio;
    private final ClienteServicio clienteServicio;
    private final EmailServicio emailServicio;

    @Override
    public String agregarCalificacion(AgregarCalificacionDTO agregarCalificacionDTO) throws Exception {
        if (!clienteServicio.existeCliente(agregarCalificacionDTO.codigoCliente())) {
            throw new ResourceNotFoundException(agregarCalificacionDTO.codigoCliente());
        }
        if (!negocioServicio.existeNegocio(agregarCalificacionDTO.codigoNegocio())) {
            throw new ResourceNotFoundException(agregarCalificacionDTO.codigoNegocio());
        }
        if (existeCalificacionClienteNegocioIDs(agregarCalificacionDTO.codigoNegocio(), agregarCalificacionDTO.codigoCliente())) {
            throw new Exception("El cliente ya ha realizado una calificacion en este negocio");
        }
        if (clienteServicio.obtenerCliente(agregarCalificacionDTO.codigoCliente()).estadoRegistro() == EstadoRegistro.INACTIVO){
            throw new Exception("El cliente está inactivo");
        }
        //Se crea la calificación
        Calificacion calificacion = new Calificacion();

        //Se asignan sus datos
        calificacion.setCodigoCliente(agregarCalificacionDTO.codigoCliente());
        calificacion.setCodigoNegocio(agregarCalificacionDTO.codigoNegocio());
        calificacion.setFecha(agregarCalificacionDTO.fecha());
        calificacion.setValoracion(agregarCalificacionDTO.valoracion());
        calificacion.setMensaje(agregarCalificacionDTO.mensaje());

        //Se agrega a la base de datos
        Calificacion calificacionGuardada = calificacionRepo.save(calificacion);

        //Codigo enviar correos de prueba
        emailServicio.enviarCorreo(new EmailDTO(
                "Tu negocio ha sido calificado",
                "Tu negocio ha sido calificado por " + clienteServicio.obtenerCliente(agregarCalificacionDTO.codigoCliente()).nickname() + ": " +
                        "\n\nValoracion: " + agregarCalificacionDTO.valoracion() + "\nDescripcion: " + agregarCalificacionDTO.mensaje(),
                clienteServicio.obtenerCliente(negocioServicio.obtenerNegocio(agregarCalificacionDTO.codigoNegocio()).codigoCliente()).email()));

        //Se obtiene el codigo de la calificación para verificar su funcionamiento
        return calificacionGuardada.getCodigoCalificacion();
    }

    @Override
    public void actualizarCalificacion(ActualizarCalificacionDTO actualizarCalificacionDTO) throws Exception {
        Calificacion calificacion = obtenerCalificacionID(actualizarCalificacionDTO.idCalificacion());
        if (clienteServicio.obtenerCliente(calificacion.getCodigoCliente()).estadoRegistro() == EstadoRegistro.INACTIVO){
            throw new Exception("No se puede cambiar la calificación de un cliente inactivo");
        }
        //Se actualizan la valoración y el mensaje
        calificacion.setValoracion(actualizarCalificacionDTO.valoracion());
        calificacion.setMensaje(actualizarCalificacionDTO.mensaje());

        //Codigo enviar correos de prueba
        emailServicio.enviarCorreo(new EmailDTO(
                "Tu negocio ha sido re-calificado",
                "Tu negocio ha sido re-calificado por " + clienteServicio.obtenerCliente(obtenerCalificacion(actualizarCalificacionDTO.idCalificacion()).codigoCliente()).nickname() + ": " +
                        "\n\nValoracion: " + actualizarCalificacionDTO.valoracion() + "\nDescripcion: " + actualizarCalificacionDTO.mensaje(),
                clienteServicio.obtenerCliente(
                        negocioServicio.obtenerNegocio(
                                obtenerCalificacion(actualizarCalificacionDTO.idCalificacion()).codigoNegocio()
                        ).codigoCliente()
                ).email()
        ));

        //Se actualiza la calificación en la base de datos
        calificacionRepo.save(calificacion);
    }

    @Override
    public List<ItemCalificacionDTO> listarCalificacionesNegocio(String idNegocio) throws ResourceNotFoundException {
        return calificacionRepo.listarCalificacionesNegocio(idNegocio);
    }

    @Override
    public void responderCalificacion(ResponderCalificacionDTO responderCalificacionDTO) throws Exception {
        Calificacion calificacion = obtenerCalificacionID(responderCalificacionDTO.idCalificacion());

        calificacion.setRespuesta(responderCalificacionDTO.respuesta());

        //Codigo enviar correos de prueba
        emailServicio.enviarCorreo(new EmailDTO(
                "Tu calificación ha sido respondida",
                "Tu negocio ha sido respondida por el dueño del negocio: " + clienteServicio.obtenerCliente(negocioServicio.obtenerNegocio(obtenerCalificacion(responderCalificacionDTO.idCalificacion()).codigoNegocio()).codigoCliente()).nickname() + ": " +
                        "\n\nRespuesta: " + responderCalificacionDTO.respuesta(),
                clienteServicio.obtenerCliente(
                        obtenerCalificacion(responderCalificacionDTO.idCalificacion()).codigoCliente()
                ).email()
        ));

        calificacionRepo.save(calificacion);
    }

    @Override
    public float obtenerCalificacionPromedioNegocio(String codigoNegocio) {
        return calificacionRepo.obtenerCalificacionPromedio(codigoNegocio);
    }

    @Override
    public DetalleCalificacionDTO obtenerCalificacion(String codigoCalificacion) throws Exception {
        Calificacion calificacion = obtenerCalificacionID(codigoCalificacion);
        return new DetalleCalificacionDTO(
                calificacion.getCodigoCalificacion(),
                calificacion.getCodigoNegocio(),
                calificacion.getCodigoCliente(),
                calificacion.getFecha(),
                calificacion.getValoracion(),
                calificacion.getMensaje(),
                calificacion.getRespuesta());
    }

    @Override
    public List<ItemCalificacionDTO> listarCalificaciones() throws Exception {
        List<Calificacion> listaCalificaciones = calificacionRepo.findAll();

        List<ItemCalificacionDTO> listaItemCalificacionDTO = new ArrayList<>();
        for (Calificacion calificacion : listaCalificaciones) {
            listaItemCalificacionDTO.add(new ItemCalificacionDTO(
                    calificacion.getCodigoCalificacion(),
                    calificacion.getCodigoNegocio(),
                    calificacion.getCodigoCliente(),
                    calificacion.getFecha(),
                    calificacion.getValoracion(),
                    calificacion.getMensaje(),
                    calificacion.getRespuesta()));
        }
        return listaItemCalificacionDTO;
    }

    //Metodos para verificar la existencia de un recurso
    private Calificacion obtenerCalificacionID(String idCalificacion) throws ResourceNotFoundException {

        Optional<Calificacion> optionalCalificacion = calificacionRepo.findById(idCalificacion);

        if (optionalCalificacion.isEmpty()) {
            throw new ResourceNotFoundException(idCalificacion);
        }

        return optionalCalificacion.get();
    }

    private boolean existeCalificacionClienteNegocioIDs(String codigoNegocio, String codigoCliente) {
        return calificacionRepo.findByCodigoNegocioAndCodigoCliente(codigoNegocio, codigoCliente).isPresent();
    }


}
