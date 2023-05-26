package com.aula.pomonooo.View;
import com.aula.pomonooo.JPA.RoleJPA;
import com.aula.pomonooo.model.Employee;
import com.aula.pomonooo.model.Player;
import com.aula.pomonooo.config.DatabaseConnectionChecker;
import com.aula.pomonooo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AppView {
    private final DatabaseConnectionChecker connectionChecker;
    @Autowired
    public AppView(DatabaseConnectionChecker connectionChecker) {
        this.connectionChecker = connectionChecker;
    }

    @GetMapping("/conn")
    public String checkDatabaseConnection() {
        connectionChecker.checkConnection();
        return "Connection check completed. Please check the console logs for the result.";
    }

    @GetMapping("/methods")
    public String executeMethods() {
        Employee employee = new Employee("Caio", "email@email.com", "1234", "ccesarfp", "dev");
        Player player = Player.getInstance("ccesarfp", "teste@teste.com", "123");
        return "<h1>Employee</h1>" +
                "<p>"+employee+"</p>" +
                "<p>"+employee.getRole().sendReport("", "")+"</p>" +
                "<hr>" +
                "<h1>Player:</h1>" +
                "<p>"+player+"</p>" +
                "<p>"+player.accessApp()+"</p>" +
                "<p>"+player.playGame()+"</p>";
    }

    @GetMapping("/role")
    public RoleJPA testRole() {
        return RoleService.getRoleByName("Analyst");
    }

}

