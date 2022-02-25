package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.UserTemp;

public interface UserTempRepository extends CrudRepository<UserTemp, Long> {
	public Optional<UserTemp> findByLoginAndPassword(String login, String password);
	public Optional<UserTemp> findByLogin(String Login);
	public UserTemp findById(int id);
	public UserTemp findByMail(String mail);
	
	public Optional<UserTemp> findByPassword(String Password);
	public Optional<UserTemp> findBySurnameAndName(String Surname, String Name);
	}

