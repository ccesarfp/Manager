
package com.aula.pomonooo.DAO;
import com.aula.pomonooo.JPA.PersonJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<PersonJPA, Integer> {

}