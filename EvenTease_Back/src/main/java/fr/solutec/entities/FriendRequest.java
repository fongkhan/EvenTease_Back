package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class FriendRequest {
	@Id @GeneratedValue
	// il faudrait que l'id soit la somme de l'id demandeur et receveur
	private Long id ;
	@ManyToOne
	private User demandeur;
	@ManyToOne
	private User receveur;
	//mettre en valeur par défaut = 2
	private int statut;
}
