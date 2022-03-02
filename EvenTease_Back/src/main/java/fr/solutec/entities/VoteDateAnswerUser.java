package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class VoteDateAnswerUser {
	@Id @GeneratedValue
	private Long id;
	private Long idAnswer;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private VoteDate voteDate;
}
