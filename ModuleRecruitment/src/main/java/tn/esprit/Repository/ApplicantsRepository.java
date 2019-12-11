package tn.esprit.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Class.Applicants;


@Repository
public interface ApplicantsRepository extends CrudRepository<Applicants, Long>  {
    
	
}

