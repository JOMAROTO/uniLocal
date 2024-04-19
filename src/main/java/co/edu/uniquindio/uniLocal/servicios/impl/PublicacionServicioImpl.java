package co.edu.uniquindio.uniLocal.servicios.impl;

import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ActualizarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.AgregarPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ItemPublicacionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ReaccionarPublicacionDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Publicacion;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.repositorios.PublicacionRepo;
import co.edu.uniquindio.uniLocal.servicios.interfaces.ClienteServicio;
import co.edu.uniquindio.uniLocal.servicios.interfaces.PublicacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PublicacionServicioImpl implements PublicacionServicio {

    private final PublicacionRepo publicacionRepo;
    private final ClienteServicio clienteServicio;

    @Override
    public String agregarPublicacion(AgregarPublicacionDTO agregarPublicacionDTO) throws ResourceNotFoundException {
        if (!clienteServicio.existeCliente(agregarPublicacionDTO.idCliente())){
            throw new ResourceNotFoundException(agregarPublicacionDTO.idCliente());
        }

        Publicacion publicacion = new Publicacion();

        publicacion.setDescripcion(agregarPublicacionDTO.descripcion());
        publicacion.setRutaImagen(agregarPublicacionDTO.rutaImagen());
        publicacion.setCodigoCliente(agregarPublicacionDTO.idCliente());
        publicacion.setFechaPublicacion(agregarPublicacionDTO.fechaPublicacion());

        Publicacion publicacionGuardada = publicacionRepo.save(publicacion);

        return publicacionGuardada.getCodigoPublicacion();

    }

    @Override
    public ItemPublicacionDTO obtenerPublicacion(String idPublicacion) throws ResourceNotFoundException {
        Publicacion publicacion = obtenerPublicacionID(idPublicacion);

        return new ItemPublicacionDTO(
                publicacion.getCodigoPublicacion(),
                publicacion.getCodigoCliente(),
                publicacion.getDescripcion(),
                publicacion.getListaMeGustas(),
                publicacion.getRutaImagen(),
                publicacion.getFechaPublicacion()
        );
    }

    @Override
    public String actualizarPublicacion(ActualizarPublicacionDTO actualizarPublicacionDTO) throws Exception {
        Publicacion publicacion = obtenerPublicacionID(actualizarPublicacionDTO.idPublicacion());

        publicacion.setDescripcion(actualizarPublicacionDTO.descripcion());
        publicacion.setRutaImagen(actualizarPublicacionDTO.rutaImagen());

        Publicacion publicacionGuardada = publicacionRepo.save(publicacion);

        return publicacionGuardada.getCodigoPublicacion();
    }

    @Override
    public void eliminarPublicacion(String idPublicacion) throws Exception {

        Publicacion publicacion = obtenerPublicacionID(idPublicacion);
        if (publicacion.getEstadoRegistro() == EstadoRegistro.INACTIVO){
            throw new Exception("Ya se encuentra eliminada");
        }
        publicacion.setEstadoRegistro(EstadoRegistro.INACTIVO);

        publicacionRepo.save(publicacion);
    }

    //Metodos para verificar la existencia de un recurso
    private Publicacion obtenerPublicacionID(String idPublicacion) throws ResourceNotFoundException {

        Optional<Publicacion> optionalPublicacion = publicacionRepo.findById(idPublicacion);

        if (optionalPublicacion.isEmpty()) {
            throw new ResourceNotFoundException(idPublicacion);
        }

        return optionalPublicacion.get();
    }

    @Override
    public boolean existePublicacion(String idPublicacion) {
        return publicacionRepo.findById(idPublicacion).isPresent();
    }

    @Override
    public void reaccionarPublicacion(ReaccionarPublicacionDTO reaccionarPublicacionDTO) throws Exception {

        if (!clienteServicio.existeCliente(reaccionarPublicacionDTO.idCliente())) {
            throw new ResourceNotFoundException(reaccionarPublicacionDTO.idCliente());
        }

        Publicacion publicacion = obtenerPublicacionID(reaccionarPublicacionDTO.idPublicacion());

        if (publicacion.getListaMeGustas().contains(reaccionarPublicacionDTO.idCliente())) {
            publicacion.getListaMeGustas().remove(reaccionarPublicacionDTO.idCliente());
        } else {
            publicacion.getListaMeGustas().add(reaccionarPublicacionDTO.idCliente());
        }

        publicacionRepo.save(publicacion);
    }
}
