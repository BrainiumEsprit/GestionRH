package net.esprit.rh.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.esprit.rh.domain.Demission;
import net.esprit.rh.domain.DemissionRepository;

@Controller
public class DemissionController {
	@Autowired
    private DemissionRepository repository; 


	
	@RequestMapping("/Afficheee")
	public String index(Model model) {
		List<Demission> Demissions = (List<Demission>) repository.findAll();
		model.addAttribute("Demissions", Demissions);
    	return "Demissions";
    }

   @RequestMapping(value = "Demission")
    public String addDemission(Model model){
    	model.addAttribute("Demission", new Demission());
        return "addDemission";
    }	

    @RequestMapping(value = "/editDemission/{id}")
    public String editDemission(@PathVariable("id") Long DemissionId, Model model){
    	model.addAttribute("Demission", repository.findById(DemissionId));
        return "editDemission";
    }	  
    
    @RequestMapping(value = "saveeeee", method = RequestMethod.POST)
    public String saveAbs(Demission Demission){
        repository.save(Demission);
    	return "redirect:/Afficheee";
    }
    
    @RequestMapping(value = "/deleteDemission/{id}", method = RequestMethod.GET)
    public String deleteDemission(@PathVariable("id") Long DemissionId, Model model) {
    	repository.deleteById(DemissionId);
        return "redirect:/Afficheee";
    }    
    

    
   /* @RequestMapping(value = "getDemissions", method = RequestMethod.GET)
    public @ResponseBody List<Demission> getDemissions() {
            return (List<Demission>)repository.findAll();
    }   */   
}
