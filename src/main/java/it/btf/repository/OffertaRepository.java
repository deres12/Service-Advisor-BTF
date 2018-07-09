package it.btf.repository;

import it.btf.dto.OffertaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Offerta;

import java.util.List;

@Repository
public interface OffertaRepository extends JpaRepository<Offerta, Long> {
        List<Offerta> findAllByFornitore_Email(String email);
}
