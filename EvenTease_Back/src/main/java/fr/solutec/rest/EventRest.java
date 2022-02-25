package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Event;
import fr.solutec.repository.EventRepository;

@RestController @CrossOrigin("*")
public class EventRest {
	@Autowired
	private EventRepository eventRepo;
	
	@GetMapping("event/public")
	public List<Event> ListEventPublic(){
		return eventRepo.findByIsPublic(true);
	}

}
