package tn.esprit.Controller;


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

import tn.esprit.Repository.ApplicantsRepository;




@Controller
public class EmailController {
	
	@Autowired
    private ApplicantsRepository repository; 
	
    @Autowired
    private JavaMailSender sender;
 
    @RequestMapping(value = "/sendmail/{id}", method = RequestMethod.GET)
    public String home(@PathVariable("id") Long ApplicantsId, Model model) {
        try {
        	String to =repository.findById(ApplicantsId).get().getEmail();
       
            sendEmail(to);
            return "redirect:/indexApp";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }
 
    private void sendEmail(String to) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setTo(to);
        helper.setText("New post added");
        helper.setSubject("A new job offer is available go ahead and check it!");
         
        sender.send(message);
    }
   
}