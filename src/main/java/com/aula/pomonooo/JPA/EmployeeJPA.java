package com.aula.pomonooo.JPA;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class EmployeeJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Relacionamento com Person
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private PersonJPA personJPA;

    // Relacionamento com Role
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleJPA roleJPA;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "<br><hr>Name: " + getName() + "<br>Username: " + personJPA.getUsername() + "<br>Email: " + personJPA.getEmail()
                + "<br>Role: " + (roleJPA != null ? roleJPA.getName() : "<br>");
    }
}
