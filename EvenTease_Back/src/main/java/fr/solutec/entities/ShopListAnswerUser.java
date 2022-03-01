package fr.solutec.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class ShopListAnswerUser {

	@Id @GeneratedValue
	private Long id;
	private int choixAchat;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private ShoppingList shoppingList;
	
}
