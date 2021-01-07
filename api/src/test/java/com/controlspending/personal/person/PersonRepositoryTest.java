package com.controlspending.personal.person;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    private final IPersonRepository personRepository;

    public PersonRepositoryTest(IPersonRepository personRepository){

        this.personRepository = personRepository;
    }

    @Test
    public void findAll(){

    }
}
