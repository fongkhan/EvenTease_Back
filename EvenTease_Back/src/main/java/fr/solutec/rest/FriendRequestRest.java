package fr.solutec.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.FriendRequest;
import fr.solutec.entities.User;
import fr.solutec.repository.FriendRequestRepository;


@RestController @CrossOrigin("*")
public class FriendRequestRest {
	@Autowired
	private FriendRequestRepository FriendRequestRepo;
	
	// _________________ DEBUT ALL FRIEND_REQUEST ___________________
	@PostMapping("friendrequest/{id}")
	public Iterable<FriendRequest> getMyFriendRequest(@PathVariable Long id){
		
		return FriendRequestRepo.findByDemandeurId(id);
	}
	// _________________ FIN ALL FRIEND_REQUEST ___________________
	
	// _________________ DEBUT DEMANDE D'AJOUT ___________________
	@PostMapping("friendrequest")
	public FriendRequest addFriend(@RequestBody FriendRequest f) {
		return FriendRequestRepo.save(f);
	}
	// _________________ FIN DEMANDE D'AJOUT ___________________
	
	// _________________ DEBUT ACCEPTATION DEMANDE D'AJOUT ___________________
	@PutMapping("friendrequest/accept")
	public FriendRequest acceptFriendRequest(@RequestBody FriendRequest f) {
		f.setStatut(1);
		return FriendRequestRepo.save(f);
	}
	// _________________ FIN ACCEPTATION DEMANDE D'AJOUT ___________________
	
	// _________________ DEBUT SUPPRESSION ou REFUS D'AJOUT ___________________
	@PutMapping("friendrequest/refuse")
	public FriendRequest refuseFriendRequest(@RequestBody FriendRequest f) {
		f.setStatut(3);
		return FriendRequestRepo.save(f);
	}
	// _________________ FIN DEBUT SUPPRESSION ou REFUS D'AJOUT ___________________
	@GetMapping("friendrequest")
	public Iterable<FriendRequest> allFriend() {
		return FriendRequestRepo.findAll();
	}
	
	@GetMapping("friendrequest/{id}/{id2}/{statut}")
	public Iterable<FriendRequest> allMyFriend(@PathVariable Long id, @PathVariable Long id2, @PathVariable int statut) {
		return FriendRequestRepo.findByDemandeurIdOrReceveurIdAndStatut(id, id2, statut);	
	}
}
