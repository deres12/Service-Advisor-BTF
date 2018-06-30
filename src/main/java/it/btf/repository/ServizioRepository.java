package it.btf.repository;

import java.util.List;
import java.util.Optional;

import it.btf.model.Professione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.btf.model.Servizio;

@Repository
public interface ServizioRepository extends JpaRepository<Servizio, Long>  {
	/*List<Servizio> findByDescrizione(String string);
	Optional<Servizio> findById(Long id);


	@Query("SELECT s FROM servizio s JOIN professione p ON p.servizi = s.id WHERE p.nome = ?1")
	List<Servizio> serviziByProfessione(String nome);

	List<Servizio> findByProfessione(Professione prof);*/
}
