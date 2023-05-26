package com.aula.pomonooo.DAO;

import com.aula.pomonooo.JPA.RoleJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDAO extends JpaRepository<RoleJPA, Integer> {
    Optional<RoleJPA> findByNameIgnoreCaseContaining(String searchText);
}
