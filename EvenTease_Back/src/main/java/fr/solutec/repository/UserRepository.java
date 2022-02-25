package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByLoginAndPassword(String login, String password);
	public Optional<User> findByMailAndPassword(String mail, String password);
	public Optional<User> findByLogin(String Login);
	public Optional<User> findByPassword(String Password);
	public Optional<User> findBySurnameAndName(String Surname, String Name);
	
	// JPQL
	@Query(value = "SELECT u FROM User u WHERE u.surname LIKE ?1% AND u.name LIKE ?2%")
	public List<User> trouverPersonBySurnameAndName(String surname, String name);
}
