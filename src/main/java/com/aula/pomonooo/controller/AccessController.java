package com.aula.pomonooo.controller;

import com.aula.pomonooo.DTO.UserAccessDTO;
import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;
import com.aula.pomonooo.model.Employee;
import com.aula.pomonooo.service.EmployeeService;
import com.aula.pomonooo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/access")
public class AccessController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, Object> payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        if (payload.get("email") == null || payload.get("password") == null) {
            String response = "";
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST); //400
        }

        PersonJPA personJPA = employeeService.findByEmail(payload.get("email").toString());

        if (employeeService.verifyPassword(personJPA.getPassword(), payload.get("password").toString()) == "Okay") {
            String response = "Password correctly";
            return new ResponseEntity<>(response, headers, HttpStatus.OK); //200
        } else {
            String response = "Incorrect password";
            return new ResponseEntity<>(response, headers, HttpStatus.UNAUTHORIZED); //401
        }

    }

    @PostMapping( "/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody Map<String, Object> payload) {
        PersonJPA personJPA = employeeService.findByEmail(payload.get("email").toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (personJPA != null) {
            String response = "Already registered user";
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<>(response, headers, HttpStatus.OK); //200
        }

        Employee employee = new Employee(payload.get("username").toString(),
                payload.get("email").toString(),
                payload.get("password").toString(),
                payload.get("name").toString(),
                payload.get("role").toString());

        employeeService.saveEmployee(employee);

        String response = "User " + employee.getName() + " created successfully";
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(response, headers, HttpStatus.CREATED); //201
    }

}
