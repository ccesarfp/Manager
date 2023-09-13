package com.aula.pomonooo.DTO;

import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
public class UserAccessDTO {

    private String email;
    private String password;
    private String status;

    public UserAccessDTO(String email, String password) {
        this.email = email;
        this.status = status;
    }

}
