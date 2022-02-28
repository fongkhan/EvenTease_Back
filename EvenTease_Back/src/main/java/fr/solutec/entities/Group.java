package fr.solutec.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity @Table(name= "groups")
public class Group {
	@Id @GeneratedValue
	private Long id;
	@ManyToOne
	private User admin;	
	@OneToMany(mappedBy = "group")
	private Set<User> member;
	private boolean publique;

}
