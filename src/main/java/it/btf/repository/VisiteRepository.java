package it.btf.repository;

import it.btf.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VisiteRepository extends JpaRepository<Visita, Long > {

     Long countByFornitore_EmailAndDataClick(String email, Date data);

    //@Query("SELECT f FROM Fornitore f WHERE  f.via.paese= ?1")
   // List<Fornitore> findAllByComune(String paese);
}
