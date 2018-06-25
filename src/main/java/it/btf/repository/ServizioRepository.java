package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Servizio;


@Repository
public interface ServizioRepository extends JpaRepository<Servizio, String>  {

}
