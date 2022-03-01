package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Event;
import fr.solutec.entities.FriendRequest;
import fr.solutec.entities.User;
import fr.solutec.entities.UserParticipateEvent;
import fr.solutec.entities.Vote;
import fr.solutec.entities.VoteAnswerUser;
import fr.solutec.entities.UserTemp;
import fr.solutec.repository.EventRepository;

import fr.solutec.repository.FriendRequestRepository;
import fr.solutec.repository.GroupRepository;

import fr.solutec.repository.UserParticipateEventRepository;
import fr.solutec.repository.UserRepository;
import fr.solutec.repository.VoteAnswerUserRepository;
import fr.solutec.repository.VoteRepository;
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
	private FriendRequestRepository FriendRequestRepo;
	@Autowired
	private UserParticipateEventRepository upeRepo;
	@Autowired
	private VoteRepository voteRepo;
	@Autowired
	private VoteAnswerUserRepository vauRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EvenTeaseBackApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	System.out.println("**************************** Début lancement ***************************");
	DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		
		// _________________ CREATION USER ___________________
		User u1 = new User( null, "fongkhan", "fong.vu@hotmail.fr", "test", "Alexis", "VUADELLE", d.parse("12/01/1998"), "0648602152", "08000", "Charelville-Mezieres", "bonjour à tous,\nJe suis très sympa et adore me prendre des cuites à la tourtel pamplemousse.", false, null);
		userRepo.save(u1);
		User u2 = new User(null, "maxpea", "maxlekekedu01@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut,\nJ'aime me bourrer a la 86 car 8 MORTS 6 BLESSÉS ... MA LUBULULE", true, null);
		userRepo.save(u2);
		User u3 = new User( null, "youssb", "youssb@gmail.com", "test3", "youssef", "BAISSI", d.parse("20/09/1998"), "0652014862", "72541", "Trifouilli-les-oies", "coucou,\nj'adore les melon que je lèche ( ͡° ͜ʖ ͡°).", true, null);
		userRepo.save(u3);
		User u4 = new User( null, "louisd", "louisd@gmail.com", "test4", "louis", "DELESTRE", d.parse("24/05/1999"), "0662435798", "72111", "Montcuq", "Hello,\nvous connaissez Shotgun ?", true, null);
		userRepo.save(u4);
		// _________________ FIN CREATION USER ___________________
		// _________________ CREATION EVENT ___________________
		Event e1 = new Event(null, "barbecue", d.parse("26/02/2022"), "Paris", false, "On va se cramer ensemble", u1, null, null);
		eventRepo.save(e1);
		Event e2 = new Event(null, "petit lazer game les boys", d.parse("27/02/2022"), "Paris", true,"fait attention à ton petit cul", u2, null, null);
		eventRepo.save(e2);
		Event e3 = new Event(null, "public party 2", d.parse("27/02/2022"), "Paris", true,"oyeah", u2, null, null);
		eventRepo.save(e3);
		Event e4 = new Event(null, "public party 3", d.parse("27/02/2022"), "Paris", true,"oyeah", u2, null, null);
		eventRepo.save(e4);
		// _________________ FIN CREATION EVENT ___________________
		// ____________ PARTICIPATION USER A EVENT ______________
		UserParticipateEvent upe1 = new UserParticipateEvent(null, u1, e2,true, false);
		upeRepo.save(upe1);
		UserParticipateEvent upe2 = new UserParticipateEvent(null, u3, e2,true, false);
		upeRepo.save(upe2);
		UserParticipateEvent upe3 = new UserParticipateEvent(null, u4, e2,true, false);
		upeRepo.save(upe3);
		// ___________ FIN PARTICIPATION USER A EVENT _____________
		// ___________ CREATION VOTE A EVENT _____________
		List<String> votesAnswer = new ArrayList<>();
		votesAnswer.add("barbecue");
		Vote v1 = new Vote(null, "activité après le lazer game", votesAnswer, e2);
		voteRepo.save(v1);
		VoteAnswerUser vau1 = new VoteAnswerUser(null, (long) 1, u1, v1);
		vauRepo.save(vau1);
		// ___________ FIN CREATION VOTE A EVENT _____________
		UserTemp utp1 = new UserTemp(null, "gadjo", "gadjo", "gadjo@gmail.com", "gadjo", "gadjo", null, null, null, null, null, null,8686);
		userTempRepo.save(utp1);
		
		
	}
	

}
