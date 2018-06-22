package it.btf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import it.btf.model.User;


@Repository
@Component 
public interface UtenteRepository extends JpaRepository<User, String> {

	List<User> findByLastName(String string);
	//User saveAndFlush(User u);
	
}
