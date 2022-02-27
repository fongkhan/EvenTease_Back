package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Event;
import fr.solutec.entities.Vote;
import fr.solutec.repository.VoteRepository;

@RestController @CrossOrigin("*")
public class VoteRest {
	@Autowired
	private VoteRepository voteRepo;
	
	// _________________ ALL VOTE ___________________
	@GetMapping("event/vote")
	public Iterable<Vote> Voteall(){
		return voteRepo.findAll();
	}
	// _________________ FIN ALL VOTE ___________________
	
	@PostMapping("event/vote/create")
	public Vote createVote(@RequestBody Vote vote) {
		return voteRepo.save(vote);
	}
	
	@PutMapping("event/vote/update/{id}")
	public Vote updateVote(@PathVariable Long id,@RequestBody Vote v) {
		v.setId(id);
		return voteRepo.save(v);
	}
}
