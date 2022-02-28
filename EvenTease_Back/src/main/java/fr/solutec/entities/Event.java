package fr.solutec.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

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
	
	@OneToMany(mappedBy = "event")
	Set<Vote> Vote;
	
	@OneToMany(mappedBy = "event") @JsonIgnore
	Set<UserParticipateEvent> participant;
}
