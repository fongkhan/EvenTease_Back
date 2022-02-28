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
	@ManyToOne
	private User admin;	
	@ManyToMany
	private Set<User> members;
//    @JoinTable(
//  		  name = "groups", 
//  		  joinColumns = @JoinColumn(name = "user_id"), 
// 		  inverseJoinColumns = @JoinColumn(name = "group_id"))

	
//	@OneToMany(mappedBy = "group")
//	private Set<User> member;
	
//    @OneToMany(mappedBy = "group"/*, cascade = {CascadeType.ALL}*/) @JsonIgnore
//    Set<GroupMember> member;
//	private boolean publique;
	
	

}
