package fr.solutec.entities;


import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity @Table(name= "groups")
public class Group {
	@Id @GeneratedValue
	private Long id;
	private String Name;
	@ManyToOne
	private User admin;	
	@ManyToMany
	private Set<User> members;

}
