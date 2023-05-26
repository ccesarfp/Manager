package com.aula.pomonooo.model.abstraction;

import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;
import com.aula.pomonooo.model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public abstract class Person {
    // properties
    private String username;
    private String email;
    private String password;

    public Person() {
        // Construtor vazio necessário para o Hibernate
    }

    public Person(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Template method that defines the process of creating a person
    public final void createPerson() {
        // Validates basic person information
        if (!validate()) {
            throw new IllegalArgumentException("Invalid person information");
        }

        // Adds additional information to the person (can be implemented by subclasses)
        addAdditionalInformation();
    }

    // Validates basic person information (to be implemented by subclasses)
    protected abstract boolean validate();

    // Adds additional information to the person (can be overridden by subclasses)
    protected void addAdditionalInformation() {
        // Default empty implementation
    }


}
