package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Event;
import fr.solutec.entities.FriendRequest;
import fr.solutec.entities.Group;
import fr.solutec.entities.User;
import fr.solutec.entities.UserParticipateEvent;
import fr.solutec.entities.UserTemp;
import fr.solutec.repository.EventRepository;

import fr.solutec.repository.FriendRequestRepository;
import fr.solutec.repository.GroupRepository;

import fr.solutec.repository.UserParticipateEventRepository;

import fr.solutec.repository.UserRepository;
import fr.solutec.repository.UserTempRepository;

@SpringBootApplication
public class EvenTeaseBackApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private FriendRequestRepository FriendRequestRepo;

	public static void main(String[] args) {
		SpringApplication.run(EvenTeaseBackApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	System.out.println("**************************** Début lancement ***************************");
	
	DateFormat d = new SimpleDateFormat("dd/MM/yyyy");


	User u1 = new User(null, "fongkhan", "fong.vu@hotmail.fr", "test", "Alexis", "VUADELLE", d.parse("12/01/1998"), "0648602152", "08000", "Charelville-Mezieres", "bonjour à tous,\nJe suis très sympa et adore me prendre des cuites à la tourtel pamplemousse.", false, null);
	userRepo.save(u1);
	User u2 = new User(null, "maxpea2", "maxlekekedu01@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true,  null);
	userRepo.save(u2);
	User u3 = new User(null, "test", "test@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true,  null);
	userRepo.save(u3);
	User u4 = new User(null, "test4", "test4@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true, null);
	userRepo.save(u4);
	Event e1 = new Event(null, "barbecue", d.parse("26/02/2022"), "Paris", false, "On va se cramer ensemble", null, null, null);
	eventRepo.save(e1);
	Event e2 = new Event(null, "petit lazer game les boys", d.parse("27/02/2022"), "Paris", true,"fait attention à ton petit cul", null, null, null);
	eventRepo.save(e2);

	FriendRequest fr1 = new FriendRequest(null, u1, u2, 1);
	FriendRequestRepo.save(fr1);

	}
	

}
