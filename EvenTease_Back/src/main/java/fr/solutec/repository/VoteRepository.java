package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;
import fr.solutec.entities.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long>{
	public List<Vote> findByEvent(Event event);
	public List<Vote> findByEventId(Long id);
}
