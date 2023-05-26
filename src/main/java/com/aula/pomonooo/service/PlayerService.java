package com.aula.pomonooo.service;

import com.aula.pomonooo.DAO.PersonDAO;
import com.aula.pomonooo.DAO.PlayerDAO;
import com.aula.pomonooo.JPA.PersonJPA;
import com.aula.pomonooo.JPA.PlayerJPA;
import com.aula.pomonooo.model.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerDAO playerDAO;
    private final PersonDAO personDAO;

    public boolean savePlayer(Player player) {
        PersonJPA personJPA = new PersonJPA();
        personJPA.setUsername(player.getUsername());
        personJPA.setEmail(player.getEmail());
        personJPA.setPassword(player.getPassword());
        PersonJPA savedPerson = personDAO.save(personJPA);

        PlayerJPA newPlayer = new PlayerJPA();
        newPlayer.setPersonJPA(savedPerson);

        playerDAO.save(newPlayer);

        return true;
    }

}
