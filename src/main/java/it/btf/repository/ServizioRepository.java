package it.btf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Servizio;

@Repository
public interface ServizioRepository extends JpaRepository<Servizio, Long>  {
	List<Servizio> findByDescrizione(String string);
	Optional<Servizio> findById(Long id);

}
