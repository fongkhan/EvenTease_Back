package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.ShopListAnswerUser;
import fr.solutec.repository.ShopListAnswerUserRepository;
import fr.solutec.repository.ShoppingListRepository;

@RestController @CrossOrigin("*")
public class ShopListAnswerUserRest {
	@Autowired
	ShopListAnswerUserRepository slauRepo;
	
	@GetMapping("event/shoplist")
	public Iterable<ShopListAnswerUser> getAllShopList(){
		return slauRepo.findAll();
	}
	
	@PostMapping("event/shoplist/add")
	public ShopListAnswerUser addShopList(@RequestBody ShopListAnswerUser slau) {
		return slauRepo.save(slau);
	}
}
