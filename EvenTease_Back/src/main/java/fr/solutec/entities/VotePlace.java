package fr.solutec.entities;

import java.util.List;

import javax.persistence.ElementCollection;
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
public class VotePlace {
	@Id @GeneratedValue
	private Long id;
	@ElementCollection
	private List<String> Places;
	
	@ManyToOne 
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
}
