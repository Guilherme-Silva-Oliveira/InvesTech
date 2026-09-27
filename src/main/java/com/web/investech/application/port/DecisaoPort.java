package com.web.investech.application.port;

import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Decisao;

import java.util.Optional;

public interface DecisaoPort {
    Decisao registrarDecisao(Decisao decisao);
    Optional<Decisao> findById(Integer id);
}
