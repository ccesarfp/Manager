package com.aula.pomonooo.JPA;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter
@Setter
public class PlayerJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonJPA personJPA;

    private int coins;

    private double money;

    @Override
    public String toString() {
        return "<br><hr>Username: " + personJPA.getUsername() + "<br>Email: " + personJPA.getEmail()
                + "<br>Coins: " + getCoins() + "<br>Money: " + getMoney();
    }
}
