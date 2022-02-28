package fr.solutec.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Vote {
	@Id @GeneratedValue
	private Long id;
	private String question;
	
	@OneToMany(mappedBy = "vote")
	@Column(nullable = false)
	private Set<VoteAnswer> voteAnswer;
	
	@ManyToOne
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
}
