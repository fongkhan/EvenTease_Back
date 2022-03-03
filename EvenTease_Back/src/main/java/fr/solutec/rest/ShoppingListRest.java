package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.ShoppingList;
import fr.solutec.repository.ShoppingListRepository;

@RestController @CrossOrigin("*")
public class ShoppingListRest {
	@Autowired
	ShoppingListRepository shopRepo;
	
	@GetMapping("event/shoppingList")
	public Iterable<ShoppingList> getAllShoppingList(){
		return shopRepo.findAll();
	}
	
	@PostMapping("shoppinglist/add")
	public ShoppingList addShoppingList(@RequestBody ShoppingList s) {
		return shopRepo.save(s);
	}
}
