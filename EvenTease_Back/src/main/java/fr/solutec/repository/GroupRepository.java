package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Groupe;
import fr.solutec.entities.User;

public interface GroupRepository extends CrudRepository<Groupe, Long>{
	public List<Groupe> findByAdmin(User admin);
	public Optional<Groupe> findById(Long id);
	// public List<Group> findByMember(User admin);
}

