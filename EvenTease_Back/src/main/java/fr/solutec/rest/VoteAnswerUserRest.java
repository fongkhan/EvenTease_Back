package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.entities.VoteAnswerUser;
import fr.solutec.repository.VoteAnswerUserRepository;

@RestController @CrossOrigin("*")
public class VoteAnswerUserRest {
	@Autowired
	private VoteAnswerUserRepository vauRepo;
	
	@GetMapping("event/vote/answer/user")
	public Iterable<VoteAnswerUser> allVoteAnswerUser(){
		return vauRepo.findAll();
	}
	
	@GetMapping("event/vote/answer/user/add")
	public VoteAnswerUser addVoteAnswerUser(@RequestBody VoteAnswerUser vau) {
		return vauRepo.save(vau);
	}
}
