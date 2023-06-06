package com.aula.pomonooo.service;

import com.aula.pomonooo.DAO.RoleDAO;
import com.aula.pomonooo.JPA.RoleJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private static RoleDAO roleDAO;

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        RoleService.roleDAO = roleDAO;
    }

    public void saveRole(String name) {
        RoleJPA roleJPA = new RoleJPA();
        roleJPA.setName(name);
        roleDAO.save(roleJPA);
    }

    public static RoleJPA getRoleById(Integer roleId) {
        Optional<RoleJPA> optionalRole = roleDAO.findById(roleId);
        return optionalRole.orElse(null);
    }

    public static RoleJPA getRoleByName(String roleName) {
        Optional<RoleJPA> optionalRole = roleDAO.findByNameIgnoreCaseContaining(roleName);
        return optionalRole.orElse(null);
    }

    public List<RoleJPA> readRoles()
    {
        return new ArrayList<>(roleDAO.findAll());
    }
}
