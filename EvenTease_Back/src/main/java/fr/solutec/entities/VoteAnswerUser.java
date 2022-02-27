package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class VoteAnswerUser {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "voteAnswer_id", nullable = false)
	private VoteAnswer voteAnswer;
	
	@ManyToOne
	private User user;
}
