package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@ManyToOne
	private User organizer;
}
