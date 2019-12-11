package net.esprit.rh.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.esprit.rh.domain.Formation;
import net.esprit.rh.domain.FormationRepository;

@Controller
public class FormationController {
	@Autowired
    private FormationRepository repository; 

	@RequestMapping("/login")
	public String login() {
    	return "login";
    }	
	
	@RequestMapping("/Formations")
	public String index(Model model) {
		List<Formation> Formations = (List<Formation>) repository.findAll();
		model.addAttribute("Formations", Formations);
    	return "Formations";
    }

    @RequestMapping(value = "add")
    public String addFormation(Model model){
    	model.addAttribute("Formation", new Formation());
        return "addFormation";
    }	

    @RequestMapping(value = "/edit/{id}")
    public String editFormation(@PathVariable("id") Long FormationId, Model model){
    	model.addAttribute("Formation", repository.findById(FormationId));
        return "editFormation";
    }	    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Formation Formation){
        repository.save(Formation);
    	return "redirect:/Formations";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFormation(@PathVariable("id") Long FormationId, Model model) {
    	repository.deleteById(FormationId);
        return "redirect:/Formations";
    }    
    

    
    @RequestMapping(value = "getFormations", method = RequestMethod.GET)
    public @ResponseBody List<Formation> getFormations() {
            return (List<Formation>)repository.findAll();
    }      
}
