package net.esprit.rh.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
  
	
	List<Employee> findByFullnameLike(String name); 
	
    
}
