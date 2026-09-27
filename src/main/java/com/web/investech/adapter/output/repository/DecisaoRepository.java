package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Decisao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisaoRepository extends JpaRepository<Decisao, Integer> {
}
