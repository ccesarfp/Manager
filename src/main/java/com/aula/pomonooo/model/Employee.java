package com.aula.pomonooo.model;
import com.aula.pomonooo.model.abstraction.Person;
import com.aula.pomonooo.strategy.role.Analyst;
import com.aula.pomonooo.strategy.role.CustomerService;
import com.aula.pomonooo.strategy.role.Developer;
import com.aula.pomonooo.strategy.role.RoleStrategy;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Employee extends Person {
    // properties
    private String name = "";
    private RoleStrategy role;


    public Employee(String username, String email, String password, String name, String roleName) {
        super(username, email, password);
        this.name = name;
        setRole(roleName);
    }

    // methods
    public void setRole(String roleName) {
        switch (roleName) {
            case "dev":
                role = new Developer();
                break;
            case "analyst":
                role = new Analyst();
                break;
            case "customerService":
                role = new CustomerService();
                break;
            default:
                System.out.println("Function:\n" + roleName + " not found");
                break;
        }
    }

    @Override
    public boolean validate() {
        // TODO: implement validate
        return true;
    }

    public RoleStrategy getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Name: " + name + "<br>Username: " + super.getUsername() + "<br>Email: " + super.getEmail()
                + "<br>Função: " + (role != null ? role.getName() : "");
    }

}

