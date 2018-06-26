package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Offerta;

@Repository
public interface OffertaRepository extends JpaRepository<Offerta, Long> {

}
