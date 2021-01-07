package com.controlspending.personal.spends;

import com.controlspending.personal.person.Person;
import com.controlspending.personal.spends.dto.SpendsCreateDTO;
import com.controlspending.personal.spends.service.ISpendsCreateService;
import com.controlspending.personal.spends.service.ISpendsFindById;
import com.controlspending.personal.spends.service.implematetion.SpendsCreate;
import com.controlspending.personal.spends.service.implematetion.SpendsFindById;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/spends")
@RequiredArgsConstructor
public class SpendsController {

    private final ISpendsCreateService spendsCreateService;
    private final ISpendsFindById spendsFindByIdService;
    private final ISpendsRepository spendsRepository;

    @PostMapping(value = "/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SpendsCreateDTO spendsDTO, @PathVariable Long idPerson) {
        spendsCreateService.create(spendsDTO, idPerson);
    }

    @GetMapping(value = "/find-all/{idPerson}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<Spends> findAllPerson(@PathVariable Long idPerson, Pageable pageable) {
        return spendsRepository.findByPessoaId(idPerson, pageable);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Spends findPerson(@PathVariable Long id) {
        return spendsFindByIdService.findSpendById(id);
    }
}
