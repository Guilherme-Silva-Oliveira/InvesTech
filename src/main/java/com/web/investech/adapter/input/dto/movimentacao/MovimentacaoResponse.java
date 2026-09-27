package com.web.investech.adapter.input.dto.movimentacao;

import com.web.investech.application.domain.model.Carteira;

public record MovimentacaoResponse(
        Double valor,
        String statusMovimentacao,
        String descricao,
        Carteira carteira
) {}