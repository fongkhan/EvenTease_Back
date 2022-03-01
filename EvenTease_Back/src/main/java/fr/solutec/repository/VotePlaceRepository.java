package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;
import fr.solutec.entities.VotePlace;

public interface VotePlaceRepository extends CrudRepository<VotePlace, Long>{
	public List<VotePlace> findByEvent(Event event);
}
