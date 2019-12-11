package net.esprit.rh.domain;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FormationRepository extends CrudRepository<Formation, Long>  {
    

	@Query( value = "Select id, compid , ((ne1+ne2+ne3+ne4)/4) as summ from matrice HAVING summ = MIN(summ)", 
			  nativeQuery = true)
	List<Matrice> Findmatri();
}

