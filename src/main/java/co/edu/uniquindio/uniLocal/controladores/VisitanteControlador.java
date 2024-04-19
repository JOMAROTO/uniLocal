package co.edu.uniquindio.uniLocal.controladores;

import co.edu.uniquindio.uniLocal.dto.JWT_DTO.MensajeDTO;
import co.edu.uniquindio.uniLocal.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.DetalleEventoDTO;
import co.edu.uniquindio.uniLocal.dto.eventoDTO.ItemEventoDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.DetalleNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.negocioDTO.ItemNegocioDTO;
import co.edu.uniquindio.uniLocal.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal.dto.publicacionDTO.ItemPublicacionDTO;
import co.edu.uniquindio.uniLocal.modelo.enumeraciones.CategoriaNegocio;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.servicios.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publica")
@RequiredArgsConstructor
public class VisitanteControlador {

    private final NegocioServicio negocioServicio;
    private final CalificacionServicio calificacionServicio;
    private final OpinionServicio opinionServicio;
    private final PublicacionServicio publicacionServicio;
    private final EventoServicio eventoServicio;

    //Acciones que puede realizar un usuario no registrado respecto a negocios

    @GetMapping("/obtener-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<DetalleNegocioDTO>>
    obtenerNegocio(@PathVariable String idNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.obtenerNegocio(idNegocio)));
    }

    @GetMapping("/listar-negocios-nombre/{nombre}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    buscarNegociosPorNombreSimilar(@PathVariable String nombre) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.buscarNegociosPorNombreSimilar(nombre)));
    }

    @GetMapping("/listar-negocios-categoria/{categoriaNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemNegocioDTO>>>
    buscarNegociosPorCategoria(@PathVariable CategoriaNegocio categoriaNegocio) {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                negocioServicio.buscarNegociosPorCategoria(categoriaNegocio)));
    }

    //Acciones que puede realizar un usuario no registrado respecto a las calificaciones

    @GetMapping("/listar-calificaciones-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemCalificacionDTO>>>
    listarCalificacionesNegocio(@PathVariable String idNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                calificacionServicio.listarCalificacionesNegocio(idNegocio)));
    }

    //Acciones que puede realizar un usuario no registrado respecto a las publicaciones

    @GetMapping("/obtener-publicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO<ItemPublicacionDTO>>
    obtenerPublicacion(@PathVariable String idPublicacion) throws ResourceNotFoundException {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                publicacionServicio.obtenerPublicacion(idPublicacion)));
    }

    //Acciones que puede realizar un usuario no registrado respecto a las opiniones

    @GetMapping("listar-opiniones-publicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO<List<ItemOpinionDTO>>>
    listarOpinionesPublicacion(@PathVariable String idPublicacion) throws ResourceNotFoundException {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                opinionServicio.listarOpinionesPublicacion(idPublicacion) ));
    }

    @GetMapping("/listar-opiniones-cliente/{idCliente}")
    public ResponseEntity<MensajeDTO<List<ItemOpinionDTO>>>
    listarOpinionesCliente(@PathVariable String idCliente) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>( false,
                opinionServicio.listarOpinionesCliente(idCliente)));
    }

    //Acciones que puede realizar un usuario no registrado respecto a los evento

    @GetMapping("/eventos/listar-eventos-negocio/{idNegocio}")
    public ResponseEntity<MensajeDTO<List<ItemEventoDTO>>>
    listarEventosNegocio(@PathVariable String idNegocio) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                eventoServicio.listarEventosNegocio(idNegocio) ));
    }

    @GetMapping("/eventos/obtener-evento/{idEvento}")
    public ResponseEntity<MensajeDTO<DetalleEventoDTO>>
    obtenerEvento(@PathVariable String idEvento) throws Exception {
        return ResponseEntity.ok().body( new MensajeDTO<>(false,
                eventoServicio.obtenerEvento(idEvento)));
    }

}
