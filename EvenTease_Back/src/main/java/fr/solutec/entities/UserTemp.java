package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor @Data
@Entity
	public class UserTemp {
		@Id @GeneratedValue
		private Long id;
	    @Column(unique=true, nullable = false)
		private String login;
	    @Column(nullable=false)
		private String password;
	    
	    @Column(unique=true, nullable = false)
		public String mail;
	    @Column(nullable=false)
		private String surname;
	    
		private String name;
	    @Column(nullable=false) @Temporal(TemporalType.DATE)
		private Date birthDate;
	    
	    private String phone;
	    private String zipCode;
	    private String town;
	    private String description;
	    @Column(nullable=true)
	    private int codeVerif;
	    
	}

