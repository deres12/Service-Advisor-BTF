package it.btf.repository;

import it.btf.model.Offerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.btf.model.RichiestaCliente;

import java.util.List;
import java.util.Optional;

@Repository
public interface RichiestaClienteRepository extends JpaRepository<RichiestaCliente, Long> {
        List<RichiestaCliente> findRichiestaClienteByCliente(String email);

    @Query("SELECT r FROM RichiestaCliente r WHERE r.cliente.email = ?1")
     List<RichiestaCliente> myQuery(String email);

}
