package net.esprit.rh.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import net.esprit.rh.domain.Employee;
import net.esprit.rh.domain.EmployeeRepository;


@Controller
public class EmployeeController {
	@Autowired
    private EmployeeRepository repository; 

	@RequestMapping("/login")
	public String login() {
    	return "login";
    }	
	
	 private final static String ACCOUNT_SID = "ACe1a1c3d6eba88295298db457d552923d";
	   private final static String AUTH_ID = "b50e206700db452b48f8740849de334e";
	
	   static {
		      Twilio.init(ACCOUNT_SID, AUTH_ID);
		   }
	@RequestMapping("/listemp")
	public String index(Model model) {
		List<Employee> Employees = (List<Employee>) repository.findAll();
		model.addAttribute("Employees", Employees);
    	return "Employees";
    }
	
    @RequestMapping(value = "add")
    public String addEmployee(Model model){
    	model.addAttribute("Employee", new Employee());
        return "addEmployee";
    }	

    @RequestMapping(value = "/edit/{id}")
    public String editEmployee(@PathVariable("id") Long EmployeeId, Model model){
    	model.addAttribute("Employee", repository.findById(EmployeeId));
        return "editEmployee";
    }	    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Employee Employee){
        repository.save(Employee);
        
        Message.creator(new PhoneNumber("+21654577109"), new PhoneNumber("+19418456469"),
                "Vous etes le bienvenue").create();
    	return "redirect:/listemp";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long EmployeeId, Model model) {
    	repository.deleteById(EmployeeId);
        return "redirect:/listemp";
    }    
        
    @RequestMapping(value = "getEmployees", method = RequestMethod.GET)
    public @ResponseBody List<Employee> getEmployees() {
            return (List<Employee>)repository.findAll();
    }   
}
