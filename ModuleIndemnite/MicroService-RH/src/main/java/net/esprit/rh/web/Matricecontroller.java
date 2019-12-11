package net.esprit.rh.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import net.esprit.rh.domain.Matrice;
import net.esprit.rh.domain.MatriceRepository;


@Controller
public class Matricecontroller {
	@Autowired
    private MatriceRepository repository; 

	
	@RequestMapping(value ="skills")
	public String indexs(Model model) {
		List<Matrice> Matrices = (List<Matrice>) repository.findAll();
		model.addAttribute("matrice", Matrices);
    	return "Matrice";
    }
   
}
