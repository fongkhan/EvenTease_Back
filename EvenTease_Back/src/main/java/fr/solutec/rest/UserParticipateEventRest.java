package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("event/participant/user")
	public List<UserParticipateEvent> getParticipantbyUser(@RequestBody User user){
		return upeRepo.findByUser(user); 
	}
	
	@PostMapping("event/participant/event")
	public List<UserParticipateEvent> getParticipantbyEvent(@RequestBody Event event){
		return upeRepo.findByEvent(event);
	}
}
