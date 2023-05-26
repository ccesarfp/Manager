package com.aula.pomonooo.model;

import com.aula.pomonooo.model.abstraction.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
@Component
@Getter
@Setter
public class Player extends Person {
    // properties
    private static Player instance;
    @Id
    private Long id;

    private int coins = 0;
    private double money = 0.0;

    protected Player() {
        // Construtor protegido necessário para o Hibernate
    }

    protected Player(String username, String email, String password) {
        super(username, email, password);
    }

    //Usando Singleton
    public static synchronized Player getInstance(String username, String email, String password) {
        if (instance == null) {
            instance = new Player(username, email, password);
        }
        return instance;
    }

    // methods
    @Override
    protected boolean validate() {
        // TODO: implement validate
        return true;
    }

    public String accessApp() {
        // TODO: implement accessApp
        return "Acessando Pomo-Nooo!";
    }

    public String playGame() {
        // TODO: implement playGame
        return "Jogando partida";
    }

    @Override
    public String toString() {
        return "Username: " + getUsername() + "\nEmail: " + getEmail();
    }

}
