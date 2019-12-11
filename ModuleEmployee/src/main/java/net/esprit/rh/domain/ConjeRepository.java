package net.esprit.rh.domain;


import java.sql.Date;
import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConjeRepository extends CrudRepository<conje, Long> {

	//List<conje> findByUser(Employee emp); 
    List<conje> findAllByid(Long id);

}
