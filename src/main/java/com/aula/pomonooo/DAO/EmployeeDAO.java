
package com.aula.pomonooo.DAO;
import com.aula.pomonooo.JPA.EmployeeJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeJPA, Integer> {

}