package com.aula.pomonooo.service;

import com.aula.pomonooo.DAO.EmployeeDAO;
import com.aula.pomonooo.DAO.PersonDAO;
import com.aula.pomonooo.DAO.PlayerDAO;
import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;

import com.aula.pomonooo.JPA.PlayerJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonDAO personDAO;
    private final EmployeeDAO employeeDAO;
    private final PlayerDAO playerDAO;

    public boolean savePerson(PersonJPA person) {
        PersonJPA newPerson = new PersonJPA();
        newPerson.setUsername(person.getUsername());
        newPerson.setEmail(person.getEmail());
        newPerson.setPassword(person.getPassword());
        personDAO.save(newPerson);

        return true;
    }

    public List<PersonJPA> readPersons()
    {
        return new ArrayList<>(personDAO.findAll());
    }

    public Optional<PersonJPA> readPerson(int id) { return personDAO.findById(id); }

    public void deletePerson(int id) {

        EmployeeJPA employee = employeeDAO.findBypersonJPA(personDAO.findById(id));
        if (employee != null) {
            employeeDAO.deleteById(Math.toIntExact(employee.getId()));
        }

        PlayerJPA player = playerDAO.findBypersonJPA(personDAO.findById(id));
        if (player != null) {
            playerDAO.deleteById(Math.toIntExact(player.getId()));
        }

        personDAO.deleteById(id);
    }

    public void updatePerson(PersonJPA person) {
        personDAO.save(person);
    }
}
