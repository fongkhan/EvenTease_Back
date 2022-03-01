package fr.solutec.rest;

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

import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.entities.UserParticipateEvent;
import fr.solutec.repository.UserParticipateEventRepository;

@RestController @CrossOrigin("*")
public class UserParticipateEventRest {
	@Autowired
	private UserParticipateEventRepository upeRepo;

	@GetMapping("event/participant")
	public Iterable<UserParticipateEvent> getAllParticipants(){
		return upeRepo.findAll();
	}
	
	@PostMapping("event/participant/participate")
	public UserParticipateEvent addParticipantsByParticipate(@RequestBody UserParticipateEvent upe){
		if(upe.getEvent() != null && upe.getUser() != null) {
			upe.setParticipate(true);
			upe.setInvited(false);
			return upeRepo.save(upe);
		} else {
			return null;
		}

	}
	
	@PostMapping("event/participant/invite")
	public UserParticipateEvent addParticipantsByInvited(@RequestBody UserParticipateEvent upe){
		upe.setParticipate(false);
		upe.setInvited(true);
		return upeRepo.save(upe);
	}
	
	@PutMapping("event/participate/modify/{id}")
	public UserParticipateEvent updateParticipants(@PathVariable Long id, @RequestBody UserParticipateEvent upe) {
		upe.setId(id);
		if(upe.isParticipate() == true || upe.isInvited() == true){
			return upeRepo.save(upe);
		} else {
			return null;
		}

	}
	
	@DeleteMapping("event/participate/delete/{id}")
	public boolean deleteParticipant(@PathVariable Long id) {
		Optional<UserParticipateEvent> upe = upeRepo.findById(id);
		if(upe.isPresent()) {
			upeRepo.deleteById(id);
			return true;
		} else {
		return false;
		}
	}
	
	@PostMapping("event/participant/user")
	public List<UserParticipateEvent> getParticipantbyUser(@RequestBody User user){
		return upeRepo.findByUser(user);
	}
	
	@PostMapping("event/participant/event")
	public List<UserParticipateEvent> getParticipantbyEvent(@RequestBody Event event){
		return upeRepo.findByEvent(event);
	}
}
