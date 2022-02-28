package fr.solutec.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Event {
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true, nullable = false)
	private String title;
	@Temporal(TemporalType.DATE)
	private Date dateEvent; 
	private String locationEvent;
	private Boolean isPublic;
	private String description;
	
	@ManyToOne
	private User organizer;
	
	@OneToMany(mappedBy = "event") @JsonIgnore
	private Set<Vote> Vote;
	
	@OneToMany(mappedBy = "event") @JsonIgnore
	Set<UserParticipateEvent> participant;
}
