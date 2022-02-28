package fr.solutec.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity @Table(name="Users")
public class User {
	@Id @GeneratedValue
	private Long id;
    @Column(unique=true, nullable = false)
	private String login;
    @Column(unique=true, nullable = false)
	public String mail;
    @Column(nullable=false)
	private String password;
    @Column(nullable=false)
	private String surname;
    @Column(nullable=false)
	private String name;
    
    @Temporal(TemporalType.DATE)
	private Date birthDate;
    private String phone;
    private String zipCode;
    private String town;
    private String description;
    private Boolean isPublic;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
//    private Set<Group> groupe_organizer;
//    @OneToMany(mappedBy = "user"/*, cascade = {CascadeType.ALL}*/) @JsonIgnore
//   Set<GroupMember> member;
    
    @OneToMany(mappedBy = "user"/*, cascade = {CascadeType.ALL}*/) @JsonIgnore
    Set<UserParticipateEvent> participant;
}
