package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;
import fr.solutec.entities.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long>{
	public Iterable<ShoppingList> findByEventId(Long id);

}
