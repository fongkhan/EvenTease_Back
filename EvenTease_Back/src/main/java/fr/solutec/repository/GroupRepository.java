package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import fr.solutec.entities.Group;
import fr.solutec.entities.User;

public interface GroupRepository extends CrudRepository<Group, Long>{
	public List<Group> findByAdmin(User admin);
	public Optional<Group> findById(Long id);
	// public List<Group> findByMember(User admin);
}

