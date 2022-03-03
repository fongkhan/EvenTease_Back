package fr.solutec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.UserParticipateEvent;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;


public interface UserParticipateEventRepository extends CrudRepository<UserParticipateEvent, Long> {
	public List<UserParticipateEvent> findByUser(User user);
	public List<UserParticipateEvent> findByUserId(Long id);
	public List<UserParticipateEvent> findByEvent(Event event);
	// JPQL
//	@Query(value = "SELECT e FROM user_participate_event AS e WHERE e.user_id =:3")
//	public List<Event> trouverByParticipant(Long idParticipant);
}
