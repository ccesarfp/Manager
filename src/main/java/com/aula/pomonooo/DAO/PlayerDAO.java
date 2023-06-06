package com.aula.pomonooo.DAO;

import com.aula.pomonooo.JPA.PersonJPA;
import com.aula.pomonooo.JPA.PlayerJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerDAO extends JpaRepository <PlayerJPA, Integer> {

    PlayerJPA findBypersonJPA(Optional<PersonJPA> personJPA);

}
