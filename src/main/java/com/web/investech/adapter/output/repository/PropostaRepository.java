package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta, Integer> {
}
