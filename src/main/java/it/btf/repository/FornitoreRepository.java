package it.btf.repository;

import it.btf.model.Guest;
import it.btf.model.Professione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.btf.model.Fornitore;

import java.util.List;

@Repository
public interface FornitoreRepository extends JpaRepository<Fornitore, String>{
    public List<Fornitore> findByProfessione( Professione p);


    @Query("SELECT f FROM Fornitore f WHERE  f.via.paese= ?1")
    List<Fornitore> findAllByComune(String paese);

}
