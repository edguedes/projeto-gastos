package com.controlspending.personal.person.service.implementation;

import com.controlspending.personal.person.IPersonRepository;
import com.controlspending.personal.person.Person;
import com.controlspending.personal.person.dto.PersonDTO;
import com.controlspending.personal.person.service.IPersonCreateService;
import com.controlspending.personal.util.RemoveSpecialCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonCreateService implements IPersonCreateService {

    private final IPersonRepository personRepository;

    public void create(PersonDTO personDTO) {

        Person person = personDTO.parseToPerson();
        person.setToken(UUID.randomUUID().toString());
        person.setName(RemoveSpecialCharacters.validate(person.getName()));
        personRepository.save(person);
    }
}
