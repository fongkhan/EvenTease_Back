package fr.solutec.rest;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.UserTemp;
import fr.solutec.registrationcheck.MyConstants;
import fr.solutec.registrationcheck.SendingEmail;
import fr.solutec.repository.UserTempRepository;


@RestController @CrossOrigin("*")
public class UserTempRest {
	@Autowired
	private UserTempRepository userTempRepo;
	
	 @Autowired
	    public JavaMailSender emailSender;
	
	@PostMapping("sign-in")
	public UserTemp InscriptionTemp(@RequestBody UserTemp p) throws MessagingException{
		SendingEmail s = new SendingEmail();
		String info = s.sendHtmlEmail(p.getMail(), emailSender);
		System.out.println("info du mail after send or i dont no " + info);
		p.setCodeVerif(MyConstants.checkCode);
		return userTempRepo.save(p);
		 
	}
}
