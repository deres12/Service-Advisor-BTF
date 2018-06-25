package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Fornitore;

@Repository
public interface FornitoreRepository extends JpaRepository<Fornitore, String>{

}
