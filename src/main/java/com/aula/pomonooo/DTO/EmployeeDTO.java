package com.aula.pomonooo.DTO;


import com.aula.pomonooo.JPA.EmployeeJPA;
import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private Long person_id;
    private String username;
    private String email;
    private Long role_id;
    private String role_name;

    public EmployeeDTO convert(EmployeeJPA employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.person_id = employee.getPersonJPA().getId();
        this.username = employee.getPersonJPA().getUsername();
        this.email = employee.getPersonJPA().getEmail();
        this.role_id = employee.getRoleJPA().getId();
        this.role_name = employee.getRoleJPA().getName();
        return this;
    }
}
