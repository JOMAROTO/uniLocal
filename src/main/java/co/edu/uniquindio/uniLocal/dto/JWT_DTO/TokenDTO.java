package co.edu.uniquindio.uniLocal.dto.JWT_DTO;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
) {
}
