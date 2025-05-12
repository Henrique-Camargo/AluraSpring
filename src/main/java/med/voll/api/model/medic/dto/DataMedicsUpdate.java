package med.voll.api.model.medic.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endress.EndressData;

public record DataMedicsUpdate(
        @NotNull
        Long id,
        String name,
        String cellphone,
        EndressData endressData) {
}
