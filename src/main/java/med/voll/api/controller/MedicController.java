package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medic.dto.DataMedics;
import med.voll.api.model.medic.jpa.Medic;
import med.voll.api.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medics")
public class MedicController {

    @Autowired
    private MedicRepository medicRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataMedics dataMedics) {
        medicRepository.save(new Medic(dataMedics));
    }
}
