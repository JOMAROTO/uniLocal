package co.edu.uniquindio.uniLocal.repositorios;

import co.edu.uniquindio.uniLocal.dto.opinionDTO.ItemOpinionDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Opinion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepo extends MongoRepository<Opinion, String> {
    List<ItemOpinionDTO> findAllByCodigoCliente(String idCliente);

    List<ItemOpinionDTO> findAllByCodigoPublicacion(String idPublicacion);
}
