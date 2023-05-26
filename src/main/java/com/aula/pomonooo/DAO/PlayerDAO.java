package com.aula.pomonooo.DAO;

import com.aula.pomonooo.JPA.PlayerJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDAO extends JpaRepository <PlayerJPA, Integer> {
}
