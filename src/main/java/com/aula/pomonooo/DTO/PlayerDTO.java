package com.aula.pomonooo.DTO;

import com.aula.pomonooo.JPA.PlayerJPA;
import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private Long person_id;
    private String username;
    private String email;
    private int coins;
    private double money;

    public PlayerDTO convert(PlayerJPA player) {
        this.id = player.getId();
        this.person_id = player.getPersonJPA().getId();
        this.username = player.getPersonJPA().getUsername();
        this.email = player.getPersonJPA().getEmail();
        this.coins = player.getCoins();
        this.money = player.getMoney();
        return this;
    }

}
