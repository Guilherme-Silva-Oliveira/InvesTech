package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtivoRepository extends JpaRepository<Ativo, Integer> {
    Optional<Ativo> findByNome(String nome);
}
