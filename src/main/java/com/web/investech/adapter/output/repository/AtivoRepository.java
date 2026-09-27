package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivoRepository extends JpaRepository<Ativo, Integer> {
}
