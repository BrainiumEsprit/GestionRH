package tn.esprit.Controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import tn.esprit.Class.Meeting;

import tn.esprit.Repository.MeetingRepository;

@Controller
public class MeetingController {
	private final static String ACCOUNT_SID = "AC8a9caffbf6a18686d5974c834441e2e6";
	   private final static String AUTH_ID = "fc545d4acc6a49d34e471d55d9fc7cfc";
	   static {
		      Twilio.init(ACCOUNT_SID, AUTH_ID);
		   }
	   public void run(ApplicationArguments arg0) throws Exception {
	      Message.creator(new PhoneNumber("to-number"), new PhoneNumber("from-number"),
	         "Message from Spring Boot Application").create();
	   }
	@Autowired
    private MeetingRepository repository; 
	
	
	@RequestMapping(value = "/addMeeting/{id}")
    public String addMeeting(@PathVariable("id") Long ApplicantsId, Model model){
		Long curr = (long) 2;
    	model.addAttribute("Meeting", new Meeting(ApplicantsId,curr));
        return "addMeeting";
    }	 
	 
	 @RequestMapping(value = "saveMeeting", method = RequestMethod.POST)
	    public String saveMeeting(Meeting a){
	        repository.save(a);
	    	return "redirect:/indexMeeting";
	    }
	 
		@RequestMapping("/indexMeeting")
		public String indexMeeting(Model model) {
			List<Meeting> Meeting = (List<Meeting>) repository.findAll();
			model.addAttribute("Meeting", Meeting);
	    	return "indexMeeting";
	    }
		 @RequestMapping(value = "/editMeeting/{id}")
		    public String editRecruitment(@PathVariable("id") Long MeetingId, Model model){
		    	model.addAttribute("Meeting", repository.findById(MeetingId));
		    	Message.creator(new PhoneNumber("+21699464202"), new PhoneNumber("+13156057007"),
		    			   "Your meeting has been delayed to "+repository.findById(MeetingId).get().getDate()+". Sorry for the inconvience").create();
		        return "editMeeting";
		    }
		 @RequestMapping(value = "/deleteMeeting/{id}", method = RequestMethod.GET)
		    public String deleteMeeting(@PathVariable("id") Long MeetingId, Model model) {
		    	repository.deleteById(MeetingId);
		        return "redirect:/indexMeeting";
		    }    
		    
	
}
