package com.controlspending.personal.person.service.implementation;

import com.controlspending.personal.exception.NotFoundException;
import com.controlspending.personal.person.IPersonRepository;
import com.controlspending.personal.person.Person;
import com.controlspending.personal.person.service.IPersonFindTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonFindTokenService implements IPersonFindTokenService {

    private final IPersonRepository personRepository;

    public Person findPersonToken(String token) {
        return personRepository.findByToken(token)
                .orElseThrow(() -> new NotFoundException(token));
    }
}
