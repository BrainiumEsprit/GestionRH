package net.esprit.rh.web;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.esprit.rh.domain.ConjeRepository;
import net.esprit.rh.domain.Employee;
import net.esprit.rh.domain.EmployeeRepository;
import net.esprit.rh.domain.conje;
import net.esprit.rh.service.EmployeeService;
import net.esprit.rh.service.TaskService;


@Controller
@RequestMapping(
        method={RequestMethod.POST} 
    )
public class ConjeController {
	@Autowired
    private ConjeRepository repository; 
     
	@Autowired
    private EmployeeRepository repositor; 
	
	@Autowired
    private EmployeeService serv;
	
	@Autowired
    private TaskService serv2;
	
	@GetMapping("/listemp2")
	public String listUsers(Model model, @RequestParam(defaultValue="")  String name) {
		model.addAttribute("list", serv.findByName(name));
		return "list";
	}
	
	@GetMapping("/addTask/{id}")
	    public String addEmployee(@PathVariable("id") Long EmployeeId, Model model){
	    	model.addAttribute("task", new conje(EmployeeId));
	        return "taskForm";
	    }
	 
	  @RequestMapping(value = "saveee", method = RequestMethod.POST)
	    public String save(conje conje){
	        repository.save(conje);
	    	return "redirect:/listemp";
	    }
	    
	  @RequestMapping(value = "/listconj/{id}" , method = RequestMethod.GET)
	    public String editEmployee(@PathVariable("id") Long id, Model model){
		  List<conje> conje = (List<conje>) repository.findAllByid(id) ;
		  model.addAttribute("listconje",conje);
	        return "listconje";
		}
	  
	  /*@RequestMapping(value = "/deleteconje/{id}", method = RequestMethod.GET)
	    public String deleteEmployee(@PathVariable("id") Long EmployeeId, Model model) {
	    	repository.deleteById(EmployeeId);
	        return "redirect:/listemp";
	    }  */
	  
	  
}
