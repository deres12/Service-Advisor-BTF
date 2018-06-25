package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.RichiestaCliente;

@Repository
public interface RichiestaClienteRepository extends JpaRepository<RichiestaCliente, String> {
	

}
