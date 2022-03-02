package fr.solutec.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
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
public class ShoppingList {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private User createur;
	private String name;
	@ElementCollection
	private List<String> Achat;
	@ElementCollection
	private List<String> Prix;
	
	@ManyToOne 
	@JoinColumn(name = "event_id", nullable = false)
	private Event event;
}
