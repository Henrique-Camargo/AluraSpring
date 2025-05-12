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
import med.voll.api.model.medic.dto.DataMedicsUpdate;

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
    private String cellphone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private EndressDataJpa endressDataJpa;

    private Boolean active;

    public Medic(DataMedics dataMedics) {
        this.active = true;
        this.name = dataMedics.name();
        this.email = dataMedics.email();
        this.cellphone = dataMedics.cellphone();
        this.crm = dataMedics.crm();
        this.specialty = dataMedics.specialty();
        this.endressDataJpa = new EndressDataJpa(dataMedics.endressData());
    }

    public void setDataMedicsUpdate(DataMedicsUpdate dataMedicsUpdate) {
        if (dataMedicsUpdate.name() != null) {
            this.name = dataMedicsUpdate.name();
        }
        if (dataMedicsUpdate.cellphone() != null) {
            this.cellphone = dataMedicsUpdate.cellphone();
        }
        if (dataMedicsUpdate.endressData() != null) {
            this.endressDataJpa.atualizarInformacoes(dataMedicsUpdate.endressData());
        }

    }

    public void delet() {
        this.active = false;
    }

}
