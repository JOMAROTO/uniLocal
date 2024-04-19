package co.edu.uniquindio.uniLocal.repositorios;

import co.edu.uniquindio.uniLocal.dto.calificacionDTO.ItemCalificacionDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Calificacion;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalificacionRepo extends MongoRepository<Calificacion, String> {
    @Aggregation({"{ $match: { codigoNegocio: ?0 } }", "{ $lookup: { from: 'negocios', localField: " +
            "'codigoNegocio', foreignField: '_id', as: 'negocio' } }", "{ $unwind: '$negocio' }", "{ " +
            "$project: { codigoCalificacion: '$codigoCalificacion', codigoNegocio: '$codigoNegocio'," +
            " codigoCliente: '$codigoCliente', fecha: '$fecha', valoracion: '$valoracion', respuesta: '$respuesta', " +
            "nombreNegocio: '$negocio.nombre', ubicacionNegocio: '$negocio.ubicacion' } }"})
    List<ItemCalificacionDTO> listarCalificacionesNegocio(String codigoNegocio);

    @Aggregation({"{ $match: { codigoNegocio: ?0 } }",
            "{ $lookup: { from: 'negocios', localField: 'codigoNegocio', foreignField: '_id', as: 'negocio' } }",
            "{ $unwind: '$negocio' }",
            "{ $group: { _id: '$codigoNegocio', promedioValoracion: { $avg: '$valoracion' } } }",
            "{ $project: { _id: 0, calificacionPromedio: '$promedioValoracion' } }"})
    float obtenerCalificacionPromedio(String codigoNegocio);

    Optional<Calificacion> findByCodigoNegocioAndCodigoCliente(String codigoNegocio, String codigoCliente);
}
