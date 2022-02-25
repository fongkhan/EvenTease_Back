package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepo;
	
	// _________________ Inscription ___________________
	@PostMapping("sign-in")
	public User Inscription(@RequestBody User p){
		return userRepo.save(p);
	}
	// _________________ FIN Inscription ___________________
	// _________________ connection ___________________
	@PostMapping("connection")
	public Optional<User> connection(@RequestBody User p){
		Optional<User> col = cologin(p);
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
	
	
	
}