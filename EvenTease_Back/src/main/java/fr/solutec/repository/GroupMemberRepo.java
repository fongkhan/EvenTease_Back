package fr.solutec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Group;

public interface GroupMemberRepo extends CrudRepository<Group, Long>{
	
	/*@Query(value = "INSERT INTO groups_members ( group_id, member_id) VALUES (?1 , ?2)")
	public void addMemberToGroup (Long idUser, Long idGroup);*/
}
