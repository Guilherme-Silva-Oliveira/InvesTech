package com.web.investech.application.port;

import com.web.investech.application.domain.model.Decisao;
import com.web.investech.application.domain.model.Operacao;

import java.util.Optional;

public interface OperacaoPort {
    Operacao registrarOperacao(Operacao operacao);
    Optional<Operacao> findById(Integer id);
}
