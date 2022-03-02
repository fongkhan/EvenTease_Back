// UserRest
// Auteur : Alexis V.

package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.entities.UserTemp;
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

	// _________________ ALL USER ___________________
	@GetMapping("user")
	public Iterable<User> getAllUser(){
		return userRepo.findAll();
	}
	// _________________ FIN ALL USER ___________________
	@PostMapping("user/create")
	public User addUser(@RequestBody User u) {
		return userRepo.save(u);
	}
	// _________________ Inscription ___________________
	@PostMapping("sign-in/confirm")
	public User Inscription(@RequestBody UserTemp userTemp) throws MessagingException {	
		UserTemp p1 = userTempRepo.findByMail(userTemp.getMail());
		
			if (p1.getCodeVerif() == userTemp.getCodeVerif()) {
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
				userTempRepo.delete(p1);
			return userRepo.save(user);
			} else {
				System.out.println("Mauvais code"); 
			return null;
			} 
			
		}
	// _________________ FIN Inscription ___________________
	
	// _________________ connection ___________________
	@PostMapping("connection")
	public Optional<User> connection(@RequestBody User p){
		Optional<User> col = cologin(p);
		p.setMail(p.getLogin());
		Optional<User> com = comail(p);
		if(col.isPresent() == false) {
			return com;
		} else {
			return col;
		}
	}
	public Optional<User> cologin(@RequestBody User p){
		return userRepo.findByLoginAndPassword(p.getLogin(), p.getPassword());
	}
	public Optional<User> comail(@RequestBody User p){
		return userRepo.findByMailAndPassword(p.getMail(), p.getPassword());
	}
	// _________________ FIN connection ___________________
	
	// _________________ modif User ___________________
	@PutMapping("user/update")
	public User updateUser(@RequestBody User u) {
		return userRepo.save(u);
	}
	// _________________ FIN modif User ___________________
	// _________________ recherche User ___________________
	@GetMapping("search/{surname}/{name}")
	public List<User> searchUser(@PathVariable String surname, @PathVariable String name){
		return userRepo.trouverPersonBySurnameAndName(surname, name);
	}
	// _________________ FIN recherche User ___________________
	// _________________ Participe a un event ___________________
	@PutMapping("user/participate/{id}")
	public User participateEvent(@PathVariable Long id,@RequestBody User u) {
		u.setId(id);
		return userRepo.save(u);
	}
	// _________________ Participe a un event ___________________
	
}