package co.edu.uniquindio.uniLocal.servicios.impl;

import co.edu.uniquindio.uniLocal.dto.moderadorDTO.ActualizarModeradorDTO;
import co.edu.uniquindio.uniLocal.modelo.documentos.Moderador;
import co.edu.uniquindio.uniLocal.modelo.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniLocal.repositorios.ModeradorRepo;
import co.edu.uniquindio.uniLocal.servicios.interfaces.ModeradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    private final ModeradorRepo moderadorRepo;

    @Override
    public void actualizarModerador(ActualizarModeradorDTO actualizarModeradorDTO) throws Exception {
        Optional<Moderador> optionalModerador = moderadorRepo.findById(actualizarModeradorDTO.id());
        if (optionalModerador.isEmpty()) {
            throw new ResourceNotFoundException(actualizarModeradorDTO.id());
        }

        Moderador moderador = optionalModerador.get();
        moderador.setNombre(actualizarModeradorDTO.nombre());
        moderador.setEmail(actualizarModeradorDTO.email());

        moderadorRepo.save(moderador);
    }

    @Override
    public boolean existeModerador(String codigoModerador) {
        return moderadorRepo.findById(codigoModerador).isPresent();
    }
}
