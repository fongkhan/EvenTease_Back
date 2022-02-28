package fr.solutec.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class VoteAnswer {
	@Id @GeneratedValue
	private Long id;
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "vote_id", nullable = false)
	private Vote vote;
	
	@OneToMany(mappedBy = "voteAnswer")
	private Set<VoteAnswerUser> voteAnswerUser;
}
