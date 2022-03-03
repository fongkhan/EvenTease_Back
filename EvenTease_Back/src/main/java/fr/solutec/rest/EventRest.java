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
	
	@PutMapping("event/update")
	public Event updateEvent(@RequestBody Event e) {
		return eventRepo.save(e);
	}
	
	@GetMapping("event")
	public Iterable<Event> getAllEvent(){
		return eventRepo.findAll();
	}
	
	@PostMapping("eventid")
	public Optional<Event> getEventById(@RequestBody Long id){
		return eventRepo.findById(id);
	}
	
	@GetMapping("event/public")
	public List<Event> ListEventPublic(){
		return eventRepo.findByIsPublic(true);
	}
	
	@GetMapping("event/organizer/{id}")
	public List<Event> ListEventOrganizer(@PathVariable Long id) {
		return eventRepo.findByOrganizerId(id);
	}
	

}
