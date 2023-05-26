package com.aula.pomonooo;

import com.aula.pomonooo.model.Employee;
import com.aula.pomonooo.model.Player;
import com.aula.pomonooo.service.EmployeeService;
import com.aula.pomonooo.service.PlayerService;
import com.aula.pomonooo.service.RoleService;
import com.aula.pomonooo.strategy.role.Analyst;
import com.aula.pomonooo.strategy.role.CustomerService;
import com.aula.pomonooo.strategy.role.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    private Employee employee;
    @Autowired
    EmployeeService eServ;

    private final Player player;
    @Autowired
    PlayerService pServ;

    private final Analyst analyst;
    private final Developer developer;
    private final CustomerService customerService;
    @Autowired
    RoleService rServ;

    @Autowired
    public DataInitializer(Player player) {
        analyst = new Analyst();
        developer = new Developer();
        customerService = new CustomerService();
        employee = new Employee("ccesarfp", "email@email.com", "1234", "Caio", "analyst");
        this.player = Player.getInstance("Cara Maneiro", "email@email.com", "1234");
    }

    @Override
    public void run(ApplicationArguments args) {
        rServ.saveRole(analyst.getName());
        rServ.saveRole(developer.getName());
        rServ.saveRole(customerService.getName());

        eServ.saveEmployee(employee);
        employee = new Employee("MellanieKP", "email@email.com", "5678", "Mellanie", "dev");
        eServ.saveEmployee(employee);
        employee = new Employee("Zunda", "email@email.com", "91011", "Gustavo", "customerService");
        eServ.saveEmployee(employee);
        pServ.savePlayer(Player.getInstance());
    }
}
