package fr.solutec.entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Groupe {
	@Id @GeneratedValue
	private Long id;
	private String Name;

	@ManyToOne
	private User admin;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<User> membres = new ArrayList<User>();

}
