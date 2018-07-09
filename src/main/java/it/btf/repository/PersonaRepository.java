package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Cliente;


@Repository
public interface PersonaRepository extends JpaRepository<Cliente, String> {
	
}
