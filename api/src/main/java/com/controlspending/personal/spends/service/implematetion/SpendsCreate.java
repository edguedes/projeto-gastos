package com.controlspending.personal.spends.service.implematetion;

import com.controlspending.personal.person.Person;
import com.controlspending.personal.person.service.implementation.PersonFindByIdService;
import com.controlspending.personal.spends.ISpendsRepository;
import com.controlspending.personal.spends.Spends;
import com.controlspending.personal.spends.dto.SpendsCreateDTO;
import com.controlspending.personal.spends.service.ISpendsCreateService;
import com.controlspending.personal.util.RemoveSpecialCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SpendsCreate implements ISpendsCreateService {

    private final PersonFindByIdService personFindByIdService;
    private final ISpendsRepository spendsRepository;

    public void create(SpendsCreateDTO spendsDTO, Long idPerson) {

        Person person = personFindByIdService.findPersonById(idPerson);
        Spends spends = spendsDTO.parseToSpends();

        spends.setPessoa(person);
        spends.setDescricao(RemoveSpecialCharacters.validate(spends.getDescricao()));
        spends.setDataTransacao(LocalDateTime.now());
        spendsRepository.save(spends);
    }
}
