package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.VotePlaceAnswerUser;
import fr.solutec.repository.VotePlaceAnswerUserRepository;

@RestController @CrossOrigin("*")
public class VotePlaceAnswerUserRest {
	@Autowired
	private VotePlaceAnswerUserRepository vpauRepo;
	
	@GetMapping("event/voteplace/user")
	public Iterable<VotePlaceAnswerUser> allVotePlaceAnswerUser(){
		return vpauRepo.findAll();
	}
	
	@PutMapping("event/voteplace/user/add")
	public VotePlaceAnswerUser addVotePlaceAnswerUser(@RequestBody VotePlaceAnswerUser vpau){
		return vpauRepo.save(vpau);
	}
}
