package fr.solutec.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
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
    
}
