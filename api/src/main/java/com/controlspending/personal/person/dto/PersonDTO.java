package com.controlspending.personal.person.dto;

import com.controlspending.personal.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    @NotBlank
    @Size(max = 40)
    private String name;

    public Person parseToPerson() {
        Person person = new Person();
        person.setName(this.getName());
        return person;
    }
}
