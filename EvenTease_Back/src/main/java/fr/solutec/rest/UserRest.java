// UserRest
// Auteur : Alexis V.

package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepo;
	// _________________ ALL USER ___________________
	@GetMapping("user")
	public Iterable<User> getAllUser(){
		return userRepo.findAll();
	}
	// _________________ FIN ALL USER ___________________
	
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
	
	// _________________ modif User ___________________
	@PutMapping("user/update/{id}")
	public User updateUser(@PathVariable Long id,@RequestBody User u) {
		u.setId(id);
		return userRepo.save(u);
	}
	// _________________ FIN modif User ___________________
	
	// _________________ recherche User ___________________
	@GetMapping("search/{surname}/{name}")
	public List<User> searchUser(@PathVariable String surname, @PathVariable String name){
		return userRepo.trouverPersonBySurnameAndName(surname, name);
	}
	// _________________ FIN recherche User ___________________
}