package it.btf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Servizio;

@Repository
public interface ServizioRepository extends JpaRepository<Servizio, Long>  {

	List<Servizio> findByDescrizione(String string);
//	Optional<Servizio> findById(Long id);

/*
	@Query("SELECT s FROM it.btf.model.Servizio s JOIN it.btf.model.Professione p ON s.")// WHERE p.nome = ?1")
	List<Servizio> serviziByProfessione(String nome);

*/

}
