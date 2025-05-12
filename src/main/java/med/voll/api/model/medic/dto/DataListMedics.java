package med.voll.api.model.medic.dto;

import med.voll.api.model.enums.Specialty;
import med.voll.api.model.medic.jpa.Medic;

public record DataListMedics(Long id, String name, String email, String crm, Specialty specialty) {

    public DataListMedics(Medic medic){
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getCrm(), medic.getSpecialty());

    }
}
