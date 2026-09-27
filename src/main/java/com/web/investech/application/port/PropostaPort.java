package com.web.investech.application.port;

import com.web.investech.application.domain.model.Decisao;
import com.web.investech.application.domain.model.Proposta;

import java.util.Optional;

public interface PropostaPort {
    Proposta registrarProposta(Proposta proposta);
    Optional<Proposta> findById(Integer id);

}
