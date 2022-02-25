package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.repository.EventRepository;

@RestController @CrossOrigin("*")
public class EventRest {
	@Autowired
	private EventRepository eventRepo;
	
	@PostMapping("event/create")
	public Event createEvent(@RequestBody Event e){
		return eventRepo.save(e);
	}
	
	@PutMapping("event/update/{id}")
	public Event updateEvent(@PathVariable Long id,@RequestBody Event e) {
		e.setId(id);
		return eventRepo.save(e);
	}
	
	@GetMapping("event")
	public Iterable<Event> getAllEvent(){
		return eventRepo.findAll();
	}
	
	@GetMapping("event/public")
	public List<Event> ListEventPublic(){
		return eventRepo.findByIsPublic(true);
	}

}
