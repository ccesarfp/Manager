package com.aula.pomonooo;
import com.aula.pomonooo.model.Employee;
import com.aula.pomonooo.model.Player;
import com.aula.pomonooo.config.DatabaseConnectionChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;

@RestController
@RequestMapping("/test")
public class PomoNoooTester {
    private final DatabaseConnectionChecker connectionChecker;
    @Autowired
    public PomoNoooTester(DatabaseConnectionChecker connectionChecker) {
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

}

