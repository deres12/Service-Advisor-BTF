package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Guest;


@Repository
public interface UserRepository extends JpaRepository<Guest, String> {
	
}