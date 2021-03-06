package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Event;
import fr.solutec.entities.FriendRequest;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.ShopListAnswerUser;
import fr.solutec.entities.ShoppingList;
import fr.solutec.entities.User;
import fr.solutec.entities.UserParticipateEvent;
import fr.solutec.entities.Vote;
import fr.solutec.entities.VoteAnswerUser;
import fr.solutec.entities.UserTemp;
import fr.solutec.repository.EventRepository;

import fr.solutec.repository.FriendRequestRepository;
import fr.solutec.repository.GroupRepository;
import fr.solutec.repository.ShopListAnswerUserRepository;
import fr.solutec.repository.ShoppingListRepository;
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
	@Autowired
	private ShoppingListRepository slRepo;
	@Autowired
	private ShopListAnswerUserRepository slauRepo;
	
	
	@Autowired
	private GroupRepository groupRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EvenTeaseBackApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	System.out.println("**************************** D??but lancement ***************************");
	DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		
		// _________________ CREATION USER ___________________
		User u1 = new User( null, "fongkhan", "fong.vu@hotmail.fr", "test", "Alexis", "VUADELLE", d.parse("12/01/1998"), "0648602152", "08000", "Charleville-Mezieres", "bonjour ?? tous, Je suis tr??s sympa et adore me balader dans Paris.", false, null);
		userRepo.save(u1);
		User u2 = new User(null, "maxpea", "maxlekekedu01@gmail.com", "test2", "maxime", "PEAN", d.parse("12/01/1995"), "0645846297", "08520", "Aiglemont", "Salut, oi c'est axie j'adore les soir??es open air", true, null);
		userRepo.save(u2);
		User u3 = new User( null, "youssb", "youssb@gmail.com", "test3", "youssef", "BAISSI", d.parse("20/09/1998"), "0652014862", "72541", "Trifouilli-les-oies", "coucou, j'organise souvent des barbecues !", true, null);
		userRepo.save(u3);
		User u4 = new User( null, "louisd", "louisd@gmail.com", "test4", "louis", "DELESTRE", d.parse("08/06/1999"), "0662435798", "59114", "Terdeghem", "Hello, J'organise r??gulierement des projections en ext??rieurs, soyez les bienvenues !", true, null);
		userRepo.save(u4);
		User u5 = new User( null, "zhizhou", "zhizhou@gmail.com", "test5", "zhi", "ZHOU", d.parse("08/06/1975"), "0785493217", "75114", "Beijing", "??????, ????????????.", true, null);
		userRepo.save(u5);
		// _________________ FIN CREATION USER ___________________
		// _________________ CREATION EVENT ___________________
		Event e1 = new Event(null, "barbecue", d.parse("26/02/2022"), "Paris", false, "La grillade hebdo",null, u1, null, null, null);
		eventRepo.save(e1);
		Event e2 = new Event(null, "lazer game", d.parse("27/02/2022"), "Paris", true,"Une jeu vid??o grandeur nature !",null, u2, null, null, null);
		eventRepo.save(e2);
		Event e3 = new Event(null, "soir??e disco", d.parse("27/02/2022"), "Paris", true,"Rejoins nous pour une soir??e r??tro !",null, u2, null, null, null);
		eventRepo.save(e3);
		Event e4 = new Event(null, "Anniversaire L??o", d.parse("27/02/2022"), "Paris", true,"On pr??pare une surprise pour L??o !",null, u2, null, null, null);
		eventRepo.save(e4);
		Event e5 = new Event(null, "Sortie Disneyland", d.parse("27/02/2022"), "Paris", true,"Sortie en famille",null, u1, null, null, null);
		eventRepo.save(e5);
		Event e6 = new Event(null, "Apr??s midi Paris", d.parse("27/02/2022"), "Paris", true,"Visite touristique",null, u3, null, null, null);
		eventRepo.save(e6);
		Event e7 = new Event(null, "Week end ?? Lille", d.parse("27/02/2022"), "Lille", true,"Viens visiter Lille !",null, u4, null, null, null);
		eventRepo.save(e7);
		// _________________ FIN CREATION EVENT ___________________
		// ____________ PARTICIPATION USER A EVENT ______________
		UserParticipateEvent upe1 = new UserParticipateEvent(null, u1, e2,true, false);
		upeRepo.save(upe1);
		UserParticipateEvent upe2 = new UserParticipateEvent(null, u3, e2,true, false);
		upeRepo.save(upe2);
		UserParticipateEvent upe3 = new UserParticipateEvent(null, u4, e2,true, false);
		upeRepo.save(upe3);
		UserParticipateEvent upe4 = new UserParticipateEvent(null, u2, e5,true, false);
		upeRepo.save(upe4);
		UserParticipateEvent upe5 = new UserParticipateEvent(null, u2, e6,true, false);
		upeRepo.save(upe5);
		UserParticipateEvent upe6 = new UserParticipateEvent(null, u2, e7,true, false);
		upeRepo.save(upe6);
		UserParticipateEvent upe7 = new UserParticipateEvent(null, u4, e6,true, false);
		upeRepo.save(upe7);
		UserParticipateEvent upe8 = new UserParticipateEvent(null, u3, e6,true, false);
		upeRepo.save(upe8);
		UserParticipateEvent upe9 = new UserParticipateEvent(null, u1, e6,true, false);
		upeRepo.save(upe9);
	
		// ___________ FIN PARTICIPATION USER A EVENT _____________
		// ___________ CREATION VOTE A EVENT _____________
		List<String> votesAnswer = new ArrayList<>();
		votesAnswer.add("barbecue");
		Vote v1 = new Vote(null, "activit?? apr??s le lazer game", votesAnswer, e2);
		voteRepo.save(v1);
		VoteAnswerUser vau1 = new VoteAnswerUser(null, (long) 1, u1, v1);
		vauRepo.save(vau1);
		// ___________ FIN CREATION VOTE A EVENT _____________
		// ___________ CREATION shopping list A EVENT _____________
		List<String> shopListAnswer = new ArrayList<>();
		shopListAnswer.add("Soda");shopListAnswer.add("Jeagermeister");
		List<String> shopListPrixAnswer = new ArrayList<>();
		shopListPrixAnswer.add("5");shopListPrixAnswer.add("20");
		ShoppingList sl1 = new ShoppingList(null, u1, "Boissons", shopListAnswer, shopListPrixAnswer, e1);
		slRepo.save(sl1);
		ShopListAnswerUser slau1 = new ShopListAnswerUser(null,2, u2, sl1);
		slauRepo.save(slau1);
		// ___________ FIN CREATION VOTE A EVENT _____________
		UserTemp utp1 = new UserTemp(null, "gadjo", "gadjo", "gadjo@gmail.com", "gadjo", "gadjo", null, null, null, null, null, null,8686);
		userTempRepo.save(utp1);
		
		FriendRequest fr1 = new FriendRequest(null, u1, u2, 1);
		FriendRequestRepo.save(fr1);
		FriendRequest fr2 = new FriendRequest(null, u2, u3, 2);
		FriendRequestRepo.save(fr2);
		FriendRequest fr3 = new FriendRequest(null, u3, u4, 3);
		FriendRequestRepo.save(fr3);
		
		Groupe g1 = new Groupe(null, "Famille Dupont", u1, null);
		groupRepo.save(g1);
		Groupe g2 = new Groupe(null, "Team grillades", u1, null);
		groupRepo.save(g2);
		Groupe g3 = new Groupe(null, "Promo 2021", u1, null);
		groupRepo.save(g3);
		Groupe g4 = new Groupe(null, "Dev 01 Solutec", u1, null);
		groupRepo.save(g4);
		
		/*
		 * Attention, l'id??al aurait ??t?? de faire une recherche avec le nom du groupe mais
		 * vu qu'on peut avoir plusieurs groupes avec le m??me nom,
		 * j'ai choisi la facilit?? en recherchant par id ; 
		 * du coup il faut ??tre s??r que un groupe a bien cet id pour que ??a marche
		 */
		addMembreToGroup("fongkhan", (long) 26);
		addMembreToGroup("youssb", (long) 26);

	}
	
	public void addMembreToGroup(String login, Long id) {
		Optional<Groupe> g = groupRepo.findById(id);
		if(!g.isPresent()) {
			System.out.println("l'id du groupe entr?? n'existe pas, v??rifier les id des groupe et modifier le numero dans addMembreToGroup()");
		}
		else {
			Optional<User> u = userRepo.findByLogin(login);
			if(!g.isPresent()) {
				System.out.println("l'user que vous voulez rajouter au groupe n'existe pas");
			}
			else {
				g.get().getMembres().add(u.get());
				groupRepo.save(g.get());
			}
		}
	}


}
