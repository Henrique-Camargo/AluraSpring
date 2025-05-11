package med.voll.api.model.endress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EndressDataJpa {

    private String street;
    private String district;
    private String cep;
    private String number;
    private String complement;
    private String city;
    private String uf;

    public EndressDataJpa(EndressData endressData) {
        this.street = endressData.street();
        this.district = endressData.district();
        this.cep = endressData.cep();
        this.number = endressData.number();
        this.complement = endressData.complement();
        this.city = endressData.city();
        this.uf = endressData.uf();
    }
}
