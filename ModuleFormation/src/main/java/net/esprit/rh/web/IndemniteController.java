package net.esprit.rh.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.esprit.rh.domain.Indemnite;
import net.esprit.rh.domain.IndemniteRepository;

@Controller
public class IndemniteController {
	@Autowired
    private IndemniteRepository repository; 

	@RequestMapping("/loginn")
	public String login() {
    	return "login";
    }	
	
	@RequestMapping("/Indemnite")
	public String index(Model model) {
		List<Indemnite> Indemnites = (List<Indemnite>) repository.findAll();
		model.addAttribute("Indemnites", Indemnites);
    	return "Indemnites";
    }

   @RequestMapping(value = "addIndem")
    public String addIndemnite(Model model){
    	model.addAttribute("Indemnite", new Indemnite());
        return "addIndemnite";
    }	

    @RequestMapping(value = "/editindem/{id}")
    public String editIndemnite(@PathVariable("id") Long IndemniteId, Model model){
    	model.addAttribute("Indemnite", repository.findById(IndemniteId));
        return "editIndemnite";
    }	  
    
    @RequestMapping(value = "saveee", method = RequestMethod.POST)
    public String saveIndem(Indemnite Indemnite){
        repository.save(Indemnite);
    	return "redirect:/Indemnite";
    }
    
    @RequestMapping(value = "/deleteindem/{id}", method = RequestMethod.GET)
    public String deleteIndemnite(@PathVariable("id") Long IndemniteId, Model model) {
    	repository.deleteById(IndemniteId);
        return "redirect:/Indemnite";
    }    
    

    
   /* @RequestMapping(value = "getIndemnites", method = RequestMethod.GET)
    public @ResponseBody List<Indemnite> getIndemnites() {
            return (List<Indemnite>)repository.findAll();
    }   */   
}
