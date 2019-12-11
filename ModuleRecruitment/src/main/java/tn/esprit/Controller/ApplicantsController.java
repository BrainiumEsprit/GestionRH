package tn.esprit.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.Class.Applicants;
import tn.esprit.Class.Recruitment;
import tn.esprit.Repository.ApplicantsRepository;
import tn.esprit.Repository.RecruitmentRepository;


@Controller
public class ApplicantsController {
	@Autowired
    private ApplicantsRepository repository; 
	
	@RequestMapping("/indexApp")
	public String indexApp(Model model) {
		List<Applicants> Applicants = (List<Applicants>) repository.findAll();
		model.addAttribute("Applicants", Applicants);
    	return "indexApp";
    }
	
	 @RequestMapping(value = "/addApplication")
	    public String addRecruitment(Model model){
	    	model.addAttribute("Applicants", new Applicants());
	        return "addApplication";
	    }
	  @RequestMapping(value = "saveApp", method = RequestMethod.POST)
	    public String saveApp(Applicants a){
	        repository.save(a);
	    	return "redirect:/indexApp";
	    } 
	  
	  @RequestMapping(value = "/editApplication/{id}")
	    public String editRecruitment(@PathVariable("id") Long ApplicantsId, Model model){
	    	model.addAttribute("Applicants", repository.findById(ApplicantsId));
	        return "editApplication";
	    }	    
	    
	    
	    @RequestMapping(value = "/deleteApplication/{id}", method = RequestMethod.GET)
	    public String deleteRecruitment(@PathVariable("id") Long ApplicantsId, Model model) {
	    	repository.deleteById(ApplicantsId);
	        return "redirect:/indexApp";
	    }    
	    

	    
	    @RequestMapping(value = "getApplication", method = RequestMethod.GET)
	    public @ResponseBody List<Applicants> getRecruitment() {
	            return (List<Applicants>)repository.findAll();
	    }     
}
