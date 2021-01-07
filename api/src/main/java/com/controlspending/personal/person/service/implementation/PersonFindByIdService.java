package com.controlspending.personal.person.service.implementation;

import com.controlspending.personal.exception.NotFoundException;
import com.controlspending.personal.person.IPersonRepository;
import com.controlspending.personal.person.Person;
import com.controlspending.personal.person.service.IPersonFindByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonFindByIdService implements IPersonFindByIdService {

    private final IPersonRepository personRepository;

    public Person findPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }
}
