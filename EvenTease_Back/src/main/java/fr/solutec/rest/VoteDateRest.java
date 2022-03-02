package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.repository.VoteDateRepository;

@RestController @CrossOrigin("*")
public class VoteDateRest {
	@Autowired
	VoteDateRepository vdRepo;
}
