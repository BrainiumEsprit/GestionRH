package tn.esprit.Repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Class.Recruitment;

@Repository
public interface RecruitmentRepository extends CrudRepository<Recruitment, Long>  {
    
	//List<Recruitment> findByFullnameLike(String name);
}

