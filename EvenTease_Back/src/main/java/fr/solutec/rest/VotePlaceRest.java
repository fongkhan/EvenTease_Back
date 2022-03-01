package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.VotePlace;
import fr.solutec.repository.VotePlaceRepository;

@RestController @CrossOrigin("*")
public class VotePlaceRest {
	@Autowired
	private VotePlaceRepository vpRepo;
	
	@GetMapping("event/voteplace")
	public Iterable<VotePlace> allVotePlace(){
		return vpRepo.findAll();
	}
	
	@PostMapping("event/voteplace/create")
	public VotePlace addVotePlace(@RequestBody VotePlace vp){
		return vpRepo.save(vp);
	}
	
	@PutMapping("event/voteplace/update/{id}")
	public VotePlace updateVotePlace(@PathVariable Long id, @RequestBody VotePlace vp){
		vp.setId(id);
		return vpRepo.save(vp);
	}
}
