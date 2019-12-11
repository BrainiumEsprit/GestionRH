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

import net.esprit.rh.domain.Absence;
import net.esprit.rh.domain.AbsenceRepository;

@Controller
public class AbsenceController {
	@Autowired
    private AbsenceRepository repository; 


	
	@RequestMapping("/Affiche")
	public String index(Model model) {
		List<Absence> Absences = (List<Absence>) repository.findAll();
		model.addAttribute("Absences", Absences);
    	return "Absences";
    }
/*
   @RequestMapping(value = "Absence")
    public String addAbsence(Model model){
    	model.addAttribute("Absence", new Absence());
        return "addAbsence";
    }	*/
	@RequestMapping(value = "Absence")
    public String addAbsence(Model model){
    	model.addAttribute("Absence", new Absence());
        return "addAbsence";
    }
    @RequestMapping(value = "/editAbsence/{id}")
    public String editAbsence(@PathVariable("id") Long AbsenceId, Model model){
    	model.addAttribute("Absence", repository.findById(AbsenceId));
        return "editAbsence";
    }	  
    
    @RequestMapping(value = "saveeee", method = RequestMethod.POST)
    public String saveAbs(Absence Absence) throws Exception{
    	sendEmail(Absence.getEmail());
        repository.save(Absence);
    	return "redirect:/Affiche";
    }
    
    @RequestMapping(value = "/deleteAbsence/{id}", method = RequestMethod.GET)
    public String deleteAbsence(@PathVariable("id") Long AbsenceId, Model model) {
    	repository.deleteById(AbsenceId);
        return "redirect:/Affiche";
    }    
    
    @Autowired
    private JavaMailSender sender;
    private void sendEmail(String to) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setTo(to);
        helper.setText("New post added");
        helper.setSubject("A new job offer is available go ahead and check it!");
         
        sender.send(message);
    }

    
   /* @RequestMapping(value = "getAbsences", method = RequestMethod.GET)
    public @ResponseBody List<Absence> getAbsences() {
            return (List<Absence>)repository.findAll();
    }   */   
}
