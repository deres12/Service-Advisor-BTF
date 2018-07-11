package it.btf.repository;

import it.btf.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VisiteRepository extends JpaRepository<Visita, Long > {

     Long countByFornitore_EmailAndDataClick(String email, Date data);

}
