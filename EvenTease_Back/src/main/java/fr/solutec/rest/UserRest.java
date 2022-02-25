package fr.solutec.rest;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.entities.UserTemp;
import fr.solutec.registrationcheck.MyConstants;
import fr.solutec.registrationcheck.SendingEmail;
import fr.solutec.repository.UserRepository;
import fr.solutec.repository.UserTempRepository;

@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserTempRepository userTempRepo;
	 @Autowired
	    public JavaMailSender emailSender;

	
	@PostMapping("connection")
	public Optional<User> login(@RequestBody User p){
		return userRepo.findByLoginAndPassword(p.getLogin(), p.getPassword());
	}
	
	
	@PostMapping("sign-in/{mail}/{codesaisi}")
	public User Inscription(@PathVariable String mail, @PathVariable int codesaisi, UserTemp p) throws MessagingException{	
		UserTemp p1 = userTempRepo.findByMail(mail);
		
			if (p1.getCodeVerif() == codesaisi) {
				User user = new User();
				user.setLogin(p1.getLogin());
				user.setPassword(p1.getPassword());
				user.setMail(p1.getMail());
				user.setSurname(p1.getSurname());
				user.setName(p1.getName());
				user.setBirthDate(p1.getBirthDate());
				user.setPhone(p1.getPhone());
				user.setZipCode(p1.getZipCode());
				user.setTown(p1.getTown());
				user.setDescription(p1.getDescription());
				
			return userRepo.save(user);
			} else {
				System.out.println("Mauvais code"); 
			return null;
			} 
			
		}
	

	/*public User Inscription(User p) throws MessagingException{
		return userRepo.save(p);
	}*/
	
	
	
}