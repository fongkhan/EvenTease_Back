package fr.solutec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;
import fr.solutec.entities.User;

public interface EventRepository extends CrudRepository<Event, Long>{
	public List<Event> findByTitle(String Title);
	public List<Event> findByIsPublic(Boolean isPublic);

	// JPQL
	@Query(value = "SELECT e FROM Event e WHERE e.organizer.login LIKE ?1%")
	public List<Event> trouverEventByOrganizerLogin(String login);
	
	public List<Event> findByOrganizer(User organizer);

}