package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao, Integer> {
}
