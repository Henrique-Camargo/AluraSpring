package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medic.dto.DataListMedics;
import med.voll.api.model.medic.dto.DataMedics;
import med.voll.api.model.medic.dto.DataMedicsUpdate;
import med.voll.api.model.medic.jpa.Medic;
import med.voll.api.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DataListMedics> findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return medicRepository.findAll(pageable).map(DataListMedics::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataMedicsUpdate dataMedicsUpdate){
        var medic = medicRepository.getReferenceById(dataMedicsUpdate.id());
        medic.setDataMedicsUpdate(dataMedicsUpdate);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delet(@PathVariable Long id){
        var medic = medicRepository.getReferenceById(id);
        medic.delet();
    }
}

