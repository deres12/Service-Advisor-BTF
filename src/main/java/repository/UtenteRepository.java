package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.User;


@Repository
public interface UtenteRepository extends JpaRepository<User, String> {

	List<User> findByLastName(String string);
	User saveAndFlush(User u);
	
}
