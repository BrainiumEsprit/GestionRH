package net.esprit.rh.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import net.esprit.rh.domain.Competence;
import net.esprit.rh.domain.CompetenceRepository;
import net.esprit.rh.domain.Matrice;
import net.esprit.rh.domain.MatriceRepository;


@Controller
public class Matricecontroller {
	@Autowired
    private MatriceRepository repository; 
	private CompetenceRepository rep;
	
	@RequestMapping(value ="skills")
	public String indexs(Model model) {
		List<Matrice> Matrices = (List<Matrice>) repository.findAll();
		List<Matrice> m = (List<Matrice>)  repository.Findmatrix();
		model.addAttribute("min",m.get(0).getCompid());
		model.addAttribute("matrice", Matrices);
	
    	return "Matrice";
    }
	
	
	 @RequestMapping(value = "addnote")
	    public String addMatrice(Model model){
			List<Competence> comps = (List<Competence>) rep.findAll();
			model.addAttribute("comps", comps);
	    	model.addAttribute("Matrice", new Matrice());
	        return "addmatrice";
	    }	
	
	@RequestMapping(value = "savemat", method = RequestMethod.POST)
    public String savemat(Matrice Matrice){
        repository.save(Matrice);
    	return "redirect:/skills";
    }
   
}
