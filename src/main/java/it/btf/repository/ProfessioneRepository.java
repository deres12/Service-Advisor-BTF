package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Professione;

@Repository
public interface ProfessioneRepository extends JpaRepository<Professione, Long> {

}
