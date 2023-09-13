package com.aula.pomonooo.service;

import com.aula.pomonooo.DAO.EmployeeDAO;
import com.aula.pomonooo.DAO.PersonDAO;
import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;
import com.aula.pomonooo.JPA.RoleJPA;
import com.aula.pomonooo.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final PersonDAO personDAO;

    public void saveEmployee(Employee employee) {
        PersonJPA personJPA = new PersonJPA();
        personJPA.setUsername(employee.getUsername());
        personJPA.setEmail(employee.getEmail());
        personJPA.setPassword(employee.getPassword());
        PersonJPA savedPerson = personDAO.save(personJPA);

        RoleJPA roleJPA = RoleService.getRoleByName(employee.getRole().getName());

        EmployeeJPA empJPA = new EmployeeJPA();
        empJPA.setName(employee.getName());
        empJPA.setPersonJPA(savedPerson);
        empJPA.setRoleJPA(roleJPA);

        employeeDAO.save(empJPA);
    }

    public List<EmployeeJPA> readEmployees()
    {
        return new ArrayList<>(employeeDAO.findAll());
    }

    public void deleteEmployee(int id) {employeeDAO.deleteById(id);}

    public void updateEmployee(EmployeeJPA employeeJPA) {employeeDAO.save(employeeJPA);}

    public Optional<EmployeeJPA> readEmployee(int id) { return employeeDAO.findById(id); }

    public PersonJPA findByEmail(String email) {
            Optional<PersonJPA> personJPA = personDAO.findByEmail(email.describeConstable());
            return personJPA.orElse(null);
    }

    public String verifyPassword(String userPassword, String enteredPassword) {
        if (Objects.equals(userPassword, enteredPassword)) return "Okay";
        return "NOkay";
    }
}
