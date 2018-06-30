package it.btf.repository;

import it.btf.model.Professione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Fornitore;

import java.util.List;

@Repository
public interface FornitoreRepository extends JpaRepository<Fornitore, String>{
    public List<Fornitore> findByProfessione( Professione p);

}
