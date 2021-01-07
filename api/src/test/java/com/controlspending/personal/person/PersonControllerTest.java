package com.controlspending.personal.person;

import com.controlspending.personal.person.dto.PersonDTO;
import com.controlspending.personal.person.service.implementation.PersonCreateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    PersonCreateService personCreateService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Test
    public void testBuscarPessoaPeloId() throws Exception{
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("Maria Joaquina");

        Person person = new Person();
        person.setName(personDTO.getName());

//        when(personCreateService.create(any(PersonDTO.class))).thenReturn(HttpStatus.CREATED);
////
////        mvc.perform(post("/api/persons"))
////                .content(mapper.writeValueAsString(personDTO))
////                .contentType

    }




}
