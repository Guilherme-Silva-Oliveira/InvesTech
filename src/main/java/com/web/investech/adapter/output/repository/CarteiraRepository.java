package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Integer> {
}
