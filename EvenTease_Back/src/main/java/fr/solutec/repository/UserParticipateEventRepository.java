package fr.solutec.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.UserParticipateEvent;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;


public interface UserParticipateEventRepository extends CrudRepository<UserParticipateEvent, Long> {
	public List<UserParticipateEvent> findByUser(User user);
	public List<UserParticipateEvent> findByEvent(Event event);
}
