package fr.solutec.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Groupe;
import fr.solutec.entities.User;
import fr.solutec.repository.GroupRepository;
import fr.solutec.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class GroupRest {
	@Autowired
	private GroupRepository groupRepo;
	@Autowired
	private UserRepository userRepo;

	// _________________ DEBUT CREATION GROUPE ___________________
	@PostMapping("group/create")
	public Groupe addGroup(@RequestBody Groupe g) {
		return groupRepo.save(g);
	}

	@PostMapping("group")
	public Groupe addGroupBidule(@RequestBody Groupe g) {
		return groupRepo.save(g);
	}

	@PostMapping("group/user/{logins}")
	public Groupe addGroupWithUser(@RequestBody Groupe g, @PathVariable String[] logins) {
		Collection<User> users = new ArrayList<>();
		for (String login : logins) {
			System.out.println(login + " les login pour créer groupe");
			Optional<User> u = userRepo.findByLogin(login);
			if (u.isPresent()) {
				// g.getMembres().add(u.get());
				users.add(u.get());
			}
		}
		g.setMembres(users);
		return groupRepo.save(g);
	}
	// _________________ FIN CREATION GROUP ___________________

	@GetMapping("groupe")
	public Iterable<Groupe> getMyGroup() {

		return groupRepo.findAll();
	}

	// _________________ DEBUT ALL MY_GROUP ___________________
	@PostMapping("mygroup")
	public List<Groupe> getMyGroup(@RequestBody User admin) {

		return groupRepo.findByAdmin(admin);
	}
	// _________________ FIN ALL MY_GROUP ___________________

	// _________________ DEBUT SUPPRESSION GROUPE ___________________
	@DeleteMapping("group/{id}")
	public boolean deleteGroup(@PathVariable Long id) {
		Optional<Groupe> g = groupRepo.findById(id);
		if (g.isPresent()) {
			groupRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	// _________________ FIN SUPPRESSION GROUP ___________________

	// _________________ DEBUT AJOUTER UN MEMBRE ___________________
	/*
	 * @PutMapping public Group addMember(@RequestBody Group g, @RequestBody
	 * Set<User> member) { g.setMember(member); return groupRepo.save(g); }
	 */
	@PutMapping("group/modify")
	public Groupe modifyGroup(@RequestBody Groupe g) {
		return groupRepo.save(g);
	}
	// _________________ FIN AJOUTER UN MEMBRE ___________________

}
