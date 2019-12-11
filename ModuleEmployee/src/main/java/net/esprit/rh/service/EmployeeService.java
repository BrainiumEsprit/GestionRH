package net.esprit.rh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.esprit.rh.domain.Employee;
import net.esprit.rh.domain.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	
	
	public List<Employee> findByName(String name) {
			// TODO Auto-generated method stub
		return  empRepository.findByFullnameLike("%"+name+"%");
		}
	
	/*public Optional<Employee> findOne(int id ) {
		
		  return empRepository.findById((long) id);
		}

		public boolean isUserPresent(int id) {
			// TODO Auto-generated method stub
			Optional<Employee> u=empRepository.findById((long) id);
			if(u!=null)
				return true;
			
			return false;
		}*/
	


	
    
}
