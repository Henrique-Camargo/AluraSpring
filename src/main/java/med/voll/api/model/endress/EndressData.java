package med.voll.api.model.endress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EndressData(

        @NotBlank
        String street,

        @NotBlank
        String district,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String city,

        @NotBlank
        String uf,

        String complement,

        String number) {
}
