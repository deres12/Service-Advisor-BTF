package it.btf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.btf.model.Professione;

import java.util.Optional;

@Repository
public interface ProfessioneRepository extends JpaRepository<Professione, Long> {

    public Optional<Professione> findAllByNome(String prof);
    public Optional<Professione> findById(Long id);
}
