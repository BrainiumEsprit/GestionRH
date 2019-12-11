package tn.esprit.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.Class.Recruitment;
import tn.esprit.Repository.RecruitmentRepository;


@Controller
public class RecruitmentController {
	@Autowired
    private RecruitmentRepository repository; 
	
	@RequestMapping("/login")
	public String login(Model model) {
    	return "login";
		
    }
	
	@RequestMapping("/allRecruitment")
	public String index(Model model) {
		List<Recruitment> Recruitment = (List<Recruitment>) repository.findAll();
		model.addAttribute("Recruitment", Recruitment);
    	return "index";
    }

    @RequestMapping(value = "/addRecruitment")
    public String addRecruitment(Model model){
    	String [] myBooleanVariable = {"Java","Angular","Nodejs","C#","C/C++"};
    	model.addAttribute("myBooleanVariable", myBooleanVariable);
    	model.addAttribute("Recruitment", new Recruitment());
        return "addRecruitment";
    }	

    @RequestMapping(value = "/editRecruitment/{id}")
    public String editRecruitment(@PathVariable("id") Long RecruitmentId, Model model){
    	String [] myBooleanVariable = {"Java","Angular","Nodejs","C#","C/C++"};
    	model.addAttribute("myBooleanVariable", myBooleanVariable);
    	model.addAttribute("Recruitment", repository.findById(RecruitmentId));
        return "editRecruitment";
    }	    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Recruitment r){
        repository.save(r);
    	return "redirect:/allRecruitment";
    }
    
    @RequestMapping(value = "/deleteRecruitment/{id}", method = RequestMethod.GET)
    public String deleteRecruitment(@PathVariable("id") Long RecruitmentId, Model model) {
    	repository.deleteById(RecruitmentId);
        return "redirect:/allRecruitment";
    }    
    
   
   /* @GetMapping("/listemp2")
	public String listUsers(Model model, @RequestParam(defaultValue="")  String name) {
		model.addAttribute("list", repository.findByName(name));
		return "list";
	}*/
    @RequestMapping(value = "getRecruitment", method = RequestMethod.GET)
    public @ResponseBody List<Recruitment> getRecruitment() {
            return (List<Recruitment>)repository.findAll();
    }      
}
