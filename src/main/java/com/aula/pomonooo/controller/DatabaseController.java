package com.aula.pomonooo.controller;

import com.aula.pomonooo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DatabaseController {

    @Autowired
    EmployeeService eServ;
    @GetMapping("/read")
    public String readBD() {
        List<String> employees = new ArrayList<>();
        eServ.readEmployees().forEach(emp -> {
            employees.add(emp.toString());
        });
        return employees.toString();
    }
}
