package com.aula.pomonooo.controller;

import com.aula.pomonooo.DTO.EmployeeDTO;
import com.aula.pomonooo.DTO.PersonDTO;
import com.aula.pomonooo.DTO.PlayerDTO;
import com.aula.pomonooo.DTO.RoleDTO;
import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;
import com.aula.pomonooo.JPA.PlayerJPA;
import com.aula.pomonooo.JPA.RoleJPA;
import com.aula.pomonooo.model.Employee;
import com.aula.pomonooo.model.Player;
import com.aula.pomonooo.service.EmployeeService;
import com.aula.pomonooo.service.PersonService;
import com.aula.pomonooo.service.PlayerService;
import com.aula.pomonooo.service.RoleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class UsersController {

    @Autowired
    EmployeeService eServ;
    @Autowired
    PlayerService pServ;
    @Autowired
    PersonService personService;
    @Autowired
    RoleService roleService;

    @GetMapping(value = "/")
    @ResponseBody
    public ResponseEntity listPersons() {
        List<PersonDTO> persons = new ArrayList<>();

        personService.readPersons().forEach(person -> {
            PersonDTO personDTO = new PersonDTO();
            personDTO.convert(person);
            persons.add(personDTO);
        });

        return this.sendingJson(persons);
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public ResponseEntity listEmployees() {
        List<EmployeeDTO> employees = new ArrayList<>();

        eServ.readEmployees().forEach(emp -> {
            EmployeeDTO empDTO = new EmployeeDTO();
            empDTO.convert(emp);
            employees.add(empDTO);
        });

        return this.sendingJson(employees);
    }

    @GetMapping(value = "/players")
    @ResponseBody
    public ResponseEntity listPlayers() {
        List<PlayerDTO> players = new ArrayList<>();

        pServ.readPlayers().forEach(player -> {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.convert(player);
            players.add(playerDTO);
        });

        return this.sendingJson(players);
    }

    @GetMapping(value = "/roles")
    @ResponseBody
    public ResponseEntity listRoles() {
        List<RoleDTO> roles = new ArrayList<>();

        roleService.readRoles().forEach(role -> {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.convert(role);
            roles.add(roleDTO);
        });

        return this.sendingJson(roles);
    }

    private ResponseEntity sendingJson(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }

    @RequestMapping("/personsPage")
    @ResponseBody
    public ModelAndView persons() {
        ModelAndView view = new ModelAndView();
        view.setViewName("pages/persons");

        return view;
    }

    @RequestMapping("/employeesPage")
    @ResponseBody
    public ModelAndView employees() {
        ModelAndView view = new ModelAndView();
        view.setViewName("pages/employees");

        return view;
    }

    @RequestMapping("/playersPage")
    @ResponseBody
    public ModelAndView players() {
        ModelAndView view = new ModelAndView();
        view.setViewName("pages/players");

        return view;
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public ModelAndView welcome() {
        ModelAndView view = new ModelAndView();
        view.setViewName("pages/login");

        return view;
    }

    @RequestMapping("/loginPage")
    @ResponseBody
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("common/formLogin");

        return view;
    }

    @RequestMapping("/createPage")
    @ResponseBody
    public ModelAndView createUser() {
        ModelAndView view = new ModelAndView();
        view.setViewName("common/formCreate");

        return view;
    }

    @RequestMapping("/home")
    @ResponseBody
    public ModelAndView homeUser() {
        ModelAndView view = new ModelAndView();
        view.setViewName("common/home");

        return view;
    }

    @PostMapping("/createEmployee")
    @ResponseBody
    public ResponseEntity createEmployee(@RequestBody Map<String, Object> payload) {
        Employee employee = new Employee(payload.get("username").toString(),
                payload.get("email").toString(),
                payload.get("password").toString(),
                payload.get("name").toString(),
                payload.get("role").toString());

        eServ.saveEmployee(employee);

        String response = "Employee " + employee.getName() + " created successfully";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/createPerson")
    @ResponseBody
    public ResponseEntity createPerson(@RequestBody Map<String, Object> payload) {
        PersonJPA personJPA = new PersonJPA();
        personJPA.setUsername(payload.get("username").toString());
        personJPA.setEmail(payload.get("email").toString());
        personJPA.setPassword(payload.get("password").toString());

        personService.savePerson(personJPA);

        String response = "Employee " + personJPA.getUsername() + " created successfully";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/createPlayer")
    @ResponseBody
    public ResponseEntity createPlayer(@RequestBody Map<String, Object> payload) {
        Player.clear();
        Player player = Player.getInstance(payload.get("username").toString(),
                payload.get("email").toString(),
                payload.get("password").toString());

        pServ.savePlayer(player);

        String response = "Player " + player.getUsername() + " created successfully";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson/{person_id}")
    public ResponseEntity deletePerson(@PathVariable("person_id") int person_id) {
        personService.deletePerson(person_id);

        String response = "Person has been successfully deleted";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{employee_id}")
    public ResponseEntity deleteEmployee(@PathVariable("employee_id") int employee_id) {
        eServ.deleteEmployee(employee_id);

        String response = "Employee has been successfully deleted";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @DeleteMapping("/deletePlayer/{player_id}")
    public ResponseEntity deletePlayer(@PathVariable("player_id") int player_id) {
        pServ.deletePlayer(player_id);

        String response = "Player has been successfully deleted";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/updatePerson")
    @ResponseBody
    public ResponseEntity updatePerson(@RequestBody Map<String, Object> payload) {
        PersonJPA person = new PersonJPA();
        person.setId(Long.parseLong((String) payload.get("id")));
        person.setUsername(payload.get("username").toString());
        person.setEmail(payload.get("email").toString());

        personService.updatePerson(person);

        String response = person.getUsername() + " has been successfully updated";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/updateEmployee")
    @ResponseBody
    public ResponseEntity updateEmployee(@RequestBody Map<String, Object> payload) {
        PersonJPA person = eServ.readEmployee(Integer.parseInt(payload.get("id").toString())).get().getPersonJPA();
        person.setUsername(payload.get("username").toString());
        person.setEmail(payload.get("email").toString());
        personService.updatePerson(person);

        RoleJPA roleJPA = RoleService.getRoleByName(payload.get("role").toString());

        EmployeeJPA employee = new EmployeeJPA();
        employee.setId(Long.parseLong((String) payload.get("id")));
        employee.setName(payload.get("name").toString());
        employee.setPersonJPA(person);
        employee.setRoleJPA(roleJPA);

        eServ.updateEmployee(employee);

        String response = employee.getName() + " has been successfully updated";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/updatePlayer")
    @ResponseBody
    public ResponseEntity updatePlayer(@RequestBody Map<String, Object> payload) {
        PersonJPA person = pServ.readPlayer(Integer.parseInt(payload.get("id").toString())).get().getPersonJPA();
        person.setUsername(payload.get("username").toString());
        person.setEmail(payload.get("email").toString());
        personService.updatePerson(person);

        PlayerJPA player = new PlayerJPA();
        player.setId(Long.parseLong((String) payload.get("id")));
        player.setPersonJPA(person);

        pServ.updatePlayer(player);

        String response = person.getUsername() + " has been successfully updated";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}
