package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class UserParticipateEvent {

	@Id @GeneratedValue
    Long id;
	
    @ManyToOne
    @JoinColumn(name = "User_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "Event_id")
    Event event;

    boolean Participate;
    boolean isInvited;
}
