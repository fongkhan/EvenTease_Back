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
	
	@PostMapping("connection-login")
	public Optional<User> login(@RequestBody User p){
		return userRepo.findByLoginAndPassword(p.getLogin(), p.getPassword());
	}
	
	@PostMapping("connection-mail")
	public Optional<User> loginmail(@RequestBody User p){
		return userRepo.findByMailAndPassword(p.getMail(), p.getPassword());
	}
	
	@PostMapping("sign-in")
	public User Inscription(@RequestBody User p){
		return userRepo.save(p);
	}
}