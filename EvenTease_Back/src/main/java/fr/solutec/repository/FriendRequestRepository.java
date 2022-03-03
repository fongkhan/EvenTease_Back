package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.FriendRequest;
import fr.solutec.entities.User;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Long> {
	public List<FriendRequest> findByDemandeurId(Long id);
	public List<FriendRequest> findByReceveurId(Long id);
	public List<FriendRequest> findByReceveurIdAndStatut(Long id, int statut);
	public Optional<FriendRequest> findById(Long id);
	
	public Iterable<FriendRequest> findByDemandeurIdOrReceveurId(Long id, Long id2);
	
	@Query(value = "SELECT f FROM FriendRequest f WHERE (f.demandeur.id = :id or f.receveur.id = :id) AND f.statut = :statut")
	public Iterable<FriendRequest> getByDemandeurorReceveurAndAccept(Long id, int statut);
}
