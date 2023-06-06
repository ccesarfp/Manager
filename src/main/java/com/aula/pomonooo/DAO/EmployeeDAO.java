
package com.aula.pomonooo.DAO;
import com.aula.pomonooo.JPA.EmployeeJPA;
import com.aula.pomonooo.JPA.PersonJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeJPA, Integer> {

    EmployeeJPA findBypersonJPA(Optional<PersonJPA> personJPA);
}
