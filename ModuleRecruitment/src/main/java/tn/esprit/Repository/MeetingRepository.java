package tn.esprit.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Class.Meeting;


@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long>  {
    
	
}

