package net.esprit.rh.web;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.esprit.rh.domain.Employee;
import net.esprit.rh.domain.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
    private EmployeeRepository repository; 


	
	@RequestMapping("/Employer")
	public String index(Model model) {
		List<Employee> Employees = (List<Employee>) repository.findAll();
		model.addAttribute("Employees", Employees);
    	return "Employees";
    }
}