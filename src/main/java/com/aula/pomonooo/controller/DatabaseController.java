package com.aula.pomonooo.controller;

import com.aula.pomonooo.model.Player;
import com.aula.pomonooo.service.EmployeeService;
import com.aula.pomonooo.service.PlayerService;
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
    @Autowired
    PlayerService pServ;

    @GetMapping("/read")
    public String readBD() {
        List<String> persons = new ArrayList<>();
        persons.add("<h1>Employees from DB:</h1>");
        eServ.readEmployees().forEach(emp -> {
            persons.add(emp.toString());
        });
        persons.add("<h1>Players from DB:</h1>");
        pServ.readEmployees().forEach(pl -> {
            persons.add(pl.toString());
        });
        return persons.toString();
    }
}
