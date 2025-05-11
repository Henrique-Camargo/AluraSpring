package med.voll.api.model.medic.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.endress.EndressData;
import med.voll.api.model.enums.Specialty;

public record DataMedics(

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid
        EndressData endressData){
}
