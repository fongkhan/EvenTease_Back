package fr.solutec.rest;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Group;
import fr.solutec.entities.User;
import fr.solutec.repository.GroupRepository;

@RestController @CrossOrigin("*")
public class GroupRest {
	@Autowired
	private GroupRepository groupRepo;

	
	// _________________ DEBUT CREATION GROUPE ___________________
	@PostMapping("group/add")
	public Group addGroup(@RequestBody Group g) {
		return groupRepo.save(g);
	}
	// _________________ FIN CREATION GROUP ___________________
	
	// _________________ DEBUT ALL MY_GROUP ___________________
	@PostMapping("mygroup")
	public List<Group> getMyGroup(@RequestBody User admin){
		
		return groupRepo.findByAdmin(admin);
	}
	// _________________ FIN ALL MY_GROUP ___________________
	
	// _________________ DEBUT SUPPRESSION GROUPE ___________________
	@DeleteMapping("group/{id}")
	public boolean deleteGroup(@PathVariable Long id) {
		Optional<Group> g = groupRepo.findById(id);
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
	@PutMapping
	public Group addMember(@RequestBody Group g, @RequestBody Set<User> member) {
		g.setMember(member);
		return groupRepo.save(g);
	}*/
	@PutMapping("group/modify")
	public Group modifyGroup(@RequestBody Group g) {
		return groupRepo.save(g);
	}
	// _________________ FIN AJOUTER UN MEMBRE ___________________
	
}

