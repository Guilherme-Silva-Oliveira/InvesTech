package com.web.investech.application.port;

import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Movimentacao;

import java.util.Optional;

public interface MovimentacaoPort {
    Movimentacao registrarMovimentacao(Movimentacao movimentacao);
    Optional<Movimentacao> findById(Integer id);
}
