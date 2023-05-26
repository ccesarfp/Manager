package com.aula.pomonooo.DAO;

import com.aula.pomonooo.JPA.PlayerJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository <PlayerJPA, Integer> {
}
