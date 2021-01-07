package com.controlspending.personal.person;

import com.controlspending.personal.person.dto.PersonDTO;
import com.controlspending.personal.person.service.IPersonCreateService;
import com.controlspending.personal.person.service.IPersonFindByIdService;
import com.controlspending.personal.person.service.IPersonFindTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonCreateService personService;
    private final IPersonFindTokenService findTokenService;
    private final IPersonFindByIdService personFindByIdService;
    private final IPersonRepository personRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody PersonDTO personDTO) {
        personService.create(personDTO);
    }

    @GetMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<Person> findAllPerson(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @GetMapping("all")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAllPersonNotPaged() {
        return personRepository.findAll();
    }

    @GetMapping(value = "/token/{token}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person findPersonToken(@PathVariable String token) {
        return findTokenService.findPersonToken(token);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Person findPersonId(@PathVariable Long id) {
        return personFindByIdService.findPersonById(id);
    }

}
