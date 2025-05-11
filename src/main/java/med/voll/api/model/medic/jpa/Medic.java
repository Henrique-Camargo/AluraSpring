package med.voll.api.model.medic.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endress.EndressData;
import med.voll.api.model.endress.EndressDataJpa;
import med.voll.api.model.enums.Specialty;
import med.voll.api.model.medic.dto.DataMedics;

@Entity(name = "medicos")
@Table(name = "tb_medics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private EndressDataJpa endressDataJpa;

    public Medic(DataMedics dataMedics) {
        this.name = dataMedics.name();
        this.email = dataMedics.email();
        this.crm = dataMedics.crm();
        this.endressDataJpa = new EndressDataJpa(dataMedics.endressData());
    }


}
