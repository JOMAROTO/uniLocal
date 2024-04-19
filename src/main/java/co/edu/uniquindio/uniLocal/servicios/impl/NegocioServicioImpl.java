package co.edu.uniquindio.uniLocal.servicios.impl;

import co.edu.uniquindio.uniLocal.dto.negocioDTO.ActualizarNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.AgregarNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Negocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoNegocio;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.EstadoRegistro;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.repositorios.NegocioRepo;
import co.edu.uniquindio.uniLocal.servicios.interfaces.ClienteServicio;
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
public class NegocioServicioImpl implements NegocioServicio {

    private final NegocioRepo negocioRepo;
    private ClienteServicio clienteServicio;

    @Override
    public String agregarNegocio(AgregarNegocioDTO agregarNegocioDTO) throws Exception {
        if (!clienteServicio.existeCliente(agregarNegocioDTO.codigoCliente())){
            throw new ResourceNotFoundException(agregarNegocioDTO.codigoCliente());
        }
        //Se crea el negocio
        Negocio negocio = new Negocio();

        //Se asignan los datos
        negocio.setCodigoCliente(agregarNegocioDTO.codigoCliente());
        negocio.setNombre(agregarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(agregarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(agregarNegocioDTO.categoriaNegocio());
        negocio.setListaTelefonos(agregarNegocioDTO.listaTelefonos());
        negocio.setListaRutasImagenes(agregarNegocioDTO.listaImagenesNegocio());
        negocio.setListaHorarios(agregarNegocioDTO.listaHorarios());
        negocio.setUbicacion(agregarNegocioDTO.ubicacion());
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);
        negocio.setEstadoRegistro(EstadoRegistro.INACTIVO);

        //Se guarda en la base de datos
        Negocio negocioGuardado = negocioRepo.save(negocio);

        //Se obtiene el código del negocio guardado
        return negocioGuardado.getCodigoNegocio();

    }

    @Override
    public void actualizarNegocio(ActualizarNegocioDTO actualizarNegocioDTO) throws Exception {

        Negocio negocio = obtenerNegocioID(actualizarNegocioDTO.codigoNegocio());

        negocio.setNombre(actualizarNegocioDTO.nombreNegocio());
        negocio.setDescripcion(actualizarNegocioDTO.descripcion());
        negocio.setCategoriaNegocio(actualizarNegocioDTO.categoriaNegocio());
        negocio.setUbicacion(actualizarNegocioDTO.ubicacion());
        negocio.setListaRutasImagenes(actualizarNegocioDTO.listaImagenesNegocio());
        negocio.setListaTelefonos(actualizarNegocioDTO.listaTelefonos());
        negocio.setListaHorarios(actualizarNegocioDTO.listaHorarios());
        negocio.setEstadoNegocio(EstadoNegocio.PENDIENTE);

        //Como el objeto cliente ya tiene un id, el save() no crea un nuevo registro sino que
        // actualiza el que ya existe
        negocioRepo.save(negocio);
    }

    @Override
    public void eliminarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        negocio.setEstadoRegistro(EstadoRegistro.INACTIVO);

        negocioRepo.save(negocio);
    }

    @Override
    public void rechazarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        negocio.setEstadoNegocio(EstadoNegocio.RECHAZADO);

        negocioRepo.save(negocio);
    }

    @Override
    public void aprobarNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        if (negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)) {
            throw new Exception("El negocio ya se encuentra aprobado ");
        }

        negocio.setEstadoNegocio(EstadoNegocio.APROBADO);

        //Se actualiza el negocio en la base de datos
        negocioRepo.save(negocio);
    }

    @Override
    public DetalleNegocioDTO obtenerNegocio(String idNegocio) throws Exception {

        Negocio negocio = obtenerNegocioID(idNegocio);

        return new DetalleNegocioDTO(
                negocio.getCodigoNegocio(),
                negocio.getCodigoCliente(),
                negocio.getNombre(),
                negocio.getDescripcion(),
                negocio.getCategoriaNegocio(),
                negocio.getEstadoNegocio(),
                negocio.getUbicacion(),
                negocio.getListaTelefonos(),
                negocio.getListaRutasImagenes(),
                negocio.getListaHorarios(),
                negocio.getEstadoRegistro()
        );
    }

    @Override
    public List<ItemNegocioDTO> buscarNegociosPorCategoria(CategoriaNegocio categoriaNegocio) {
        List<Negocio> negocios = negocioRepo.findAllByCategoriaNegocio(categoriaNegocio);

        return listarNegocios(negocios);
    }

    //En caso de que no se dé un nombre exacto, busca por aquellos que tengan
    //coincidencias
    @Override
    public List<ItemNegocioDTO> buscarNegociosPorNombreSimilar(String nombre) {

        List<Negocio> negocios = negocioRepo.findAllByNombreLikeIgnoreCase(nombre);

        //Creamos una lista de DTOs de negocios

        return listarNegocios(negocios);
    }

    @Override
    public List<ItemNegocioDTO> filtrarPorEstado(EstadoNegocio estadoNegocio) {

        List<Negocio> negocios = negocioRepo.findAllByEstadoNegocio(estadoNegocio);

        //Creamos una lista de DTOs de negocios

        return listarNegocios(negocios);

    }

    @Override
    public List<ItemNegocioDTO> listarNegociosPropietario(String idPropietario) throws Exception {
        return negocioRepo.findAllByCodigoCliente(idPropietario);
    }

    //Metodos para verificar existencia de datos
    @Override
    public boolean existeNegocio(String idNegocio) {
        return negocioRepo.findById(idNegocio).isPresent();
    }

    private Negocio obtenerNegocioID(String idNegocio) throws ResourceNotFoundException {

        Optional<Negocio> optionalNegocio = negocioRepo.findById(idNegocio);

        if (optionalNegocio.isEmpty()) {
            throw new ResourceNotFoundException(idNegocio);
        }

        return optionalNegocio.get();
    }

    private List<ItemNegocioDTO> listarNegocios(List<Negocio> negocios) {

        //Creamos una lista de DTOs de negocios
        List<ItemNegocioDTO> itemNegocioDTOS = new ArrayList<>();

        for (Negocio negocio : negocios) {
            if (negocio.getEstadoRegistro().equals(EstadoRegistro.ACTIVO) &&
                    negocio.getEstadoNegocio().equals(EstadoNegocio.APROBADO)) {
                itemNegocioDTOS.add(
                        new ItemNegocioDTO(
                                negocio.getCodigoNegocio(),
                                negocio.getCodigoCliente(),
                                negocio.getNombre(),
                                negocio.getDescripcion(),
                                negocio.getCategoriaNegocio(),
                                negocio.getEstadoNegocio(),
                                negocio.getUbicacion(),
                                negocio.getListaTelefonos(),
                                negocio.getListaRutasImagenes(),
                                negocio.getListaHorarios(),
                                negocio.getEstadoRegistro()
                        )
                );
            }
        }
        return itemNegocioDTOS;
    }
}
