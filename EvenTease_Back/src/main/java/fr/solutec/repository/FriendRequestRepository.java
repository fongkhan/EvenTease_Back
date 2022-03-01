package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.FriendRequest;
import fr.solutec.entities.User;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Long> {
	public List<FriendRequest> findByDemandeurId(Long id);
	public List<FriendRequest> findByReceveur(User u);
	public Optional<FriendRequest> findById(Long id);
}
