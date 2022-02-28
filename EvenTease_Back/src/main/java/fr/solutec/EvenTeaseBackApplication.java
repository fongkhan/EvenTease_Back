package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

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
<<<<<<< HEAD
import fr.solutec.repository.FriendRequestRepository;
import fr.solutec.repository.GroupRepository;
//import fr.solutec.repository.GroupRepository;
=======
import fr.solutec.repository.UserParticipateEventRepository;
>>>>>>> branch 'master' of https://github.com/fongkhan/EvenTease_Back.git
import fr.solutec.repository.UserRepository;
import fr.solutec.repository.UserTempRepository;

@SpringBootApplication
public class EvenTeaseBackApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserTempRepository userTempRepo;

	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private UserParticipateEventRepository upeRepo;
	
	@Autowired
	private FriendRequestRepository FriendRequestRepo;
	@Autowired
	private GroupRepository groupRepo;
	public static void main(String[] args) {
		SpringApplication.run(EvenTeaseBackApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("**************************** Début lancement ***************************");
		
		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		
<<<<<<< HEAD
		User u1 = new User(null, "fongkhan", "fong.vu@hotmail.fr", "test", "Alexis", "VUADELLE", d.parse("12/01/1998"), "0648602152", "08000", "Charelville-Mezieres", "bonjour à tous,\nJe suis très sympa et adore me prendre des cuites à la tourtel pamplemousse.", false, null);
=======
		User u1 = new User( null, "fongkhan", "fong.vu@hotmail.fr", "test", "Alexis", "VUADELLE", d.parse("12/01/1998"), "0648602152", "08000", "Charelville-Mezieres", "bonjour à tous,\nJe suis très sympa et adore me prendre des cuites à la tourtel pamplemousse.", false, null);
>>>>>>> branch 'master' of https://github.com/fongkhan/EvenTease_Back.git
		userRepo.save(u1);
<<<<<<< HEAD
		User u2 = new User(null, "maxpea2", "maxlekekedu01@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true, null);
=======
		User u2 = new User(null, "maxpea", "maxlekekedu01@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true, null);
>>>>>>> branch 'master' of https://github.com/fongkhan/EvenTease_Back.git
		userRepo.save(u2);
<<<<<<< HEAD
		User u3 = new User(null, "test", "test@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true, null);
		userRepo.save(u3);
		User u4 = new User(null, "test4", "test4@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true, null);
		userRepo.save(u4);
		Event e1 = new Event(null, "barbecue", d.parse("26/02/2022"), "Paris", false, u1, "On va se cramer ensemble");
=======
		User u3 = new User( null, "youssb", "youssb@gmail.com", "test3", "youssef", "BAISSI", d.parse("20/09/1998"), "0652014862", "72541", "Trifouilli-les-oies", "coucou,\nj'adore les melon que je lèche ( ͡° ͜ʖ ͡°).", true, null);
		userRepo.save(u3);
		User u4 = new User( null, "louisd", "louisd@gmail.com", "test4", "louis", "DELESTRE", d.parse("24/05/1999"), "0662435798", "72111", "Montcuq", "Hello,\nvous connaissez Shotgun ?", true, null);
		userRepo.save(u4);
		
		Event e1 = new Event(null, "barbecue", d.parse("26/02/2022"), "Paris", false, "On va se cramer ensemble", u1, null, null);
>>>>>>> branch 'master' of https://github.com/fongkhan/EvenTease_Back.git
		eventRepo.save(e1);
<<<<<<< HEAD
		Event e2 = new Event(null, "petit lazer game les boys", d.parse("27/02/2022"), "Paris", true, u2, "fais attention à ton petit cul");
=======
		Event e2 = new Event(null, "petit lazer game les boys", d.parse("27/02/2022"), "Paris", true,"fait attention à ton petit cul", u2, null, null);
>>>>>>> branch 'master' of https://github.com/fongkhan/EvenTease_Back.git
		eventRepo.save(e2);
<<<<<<< HEAD
		FriendRequest fr1 = new FriendRequest(null, u1, u2, 1);
		FriendRequestRepo.save(fr1);
		Set<User> set1 = new HashSet<User>(); 
		set1.add(u2);
		set1.add(u3);
		
		
		Group g1 = new Group (null, u1, set1, false);
		groupRepo.save(g1);
=======
		
		UserParticipateEvent upe1 = new UserParticipateEvent(null, u1, e2,true, false);
		upeRepo.save(upe1);
		UserParticipateEvent upe2 = new UserParticipateEvent(null, u3, e2,true, false);
		upeRepo.save(upe2);
		UserParticipateEvent upe3 = new UserParticipateEvent(null, u4, e2,true, false);
		upeRepo.save(upe3);
		
		UserTemp utp1 = new UserTemp(null, "gadjo", "gadjo", "gadjo@gmail.com", "gadjo", "gadjo", null, null, null, null, null, null,8686);
		userTempRepo.save(utp1);
>>>>>>> branch 'master' of https://github.com/fongkhan/EvenTease_Back.git
	}
	

}
