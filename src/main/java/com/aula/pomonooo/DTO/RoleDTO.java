package com.aula.pomonooo.DTO;

import com.aula.pomonooo.JPA.PlayerJPA;
import com.aula.pomonooo.JPA.RoleJPA;

public class RoleDTO {
    private Long id;
    private String name;

    public RoleDTO convert(RoleJPA role) {
        this.id = role.getId();
        this.name = role.getName();

        return this;
    }
}
