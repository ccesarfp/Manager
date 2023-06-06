package com.aula.pomonooo.DTO;

import com.aula.pomonooo.JPA.PersonJPA;
import lombok.Data;

@Data
public class PersonDTO {
    private Long id;
    private String username;
    private String email;

    public PersonDTO convert(PersonJPA person) {
        this.id = person.getId();
        this.username = person.getUsername();
        this.email = person.getEmail();
        return this;
    }
}
