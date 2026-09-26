package com.web.investech.application.port;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Proposta;

import java.util.Optional;

public interface AtivoPort {
    Ativo registrarAtivo(Ativo ativo);
    Optional<Ativo> findById(Integer id);

}
