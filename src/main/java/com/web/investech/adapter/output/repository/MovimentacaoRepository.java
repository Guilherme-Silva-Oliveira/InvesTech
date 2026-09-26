package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
