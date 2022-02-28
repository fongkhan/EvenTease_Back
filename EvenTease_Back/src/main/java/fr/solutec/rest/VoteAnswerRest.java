package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.VoteAnswer;
import fr.solutec.repository.VoteAnswerRepository;

@RestController @CrossOrigin("*")
public class VoteAnswerRest {
	@Autowired
	private VoteAnswerRepository vaRepo;
	
	@GetMapping("event/vote/answer")
	public Iterable<VoteAnswer> VoteAnswerAll(){
		return vaRepo.findAll();
	}
	
	@PostMapping("event/vote/answer/create")
	public VoteAnswer createVoteAnswer(@RequestBody VoteAnswer va) {
		return vaRepo.save(va);
	}
	
	@PostMapping("event/vote/answer/update/{id}")
	public VoteAnswer updateVoteAnswer(@PathVariable Long id, @RequestBody VoteAnswer va) {
		va.setId(id);
		return vaRepo.save(va);
	}
}
