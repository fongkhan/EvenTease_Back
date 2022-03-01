package fr.solutec.entities;

import java.util.List;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class VoteDate {
	@Id @GeneratedValue
	private Long id;
	@ElementCollection @Temporal(TemporalType.DATE)
	private List<Date> Date;
	@ManyToOne
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
}
