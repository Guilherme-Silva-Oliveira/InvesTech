package com.web.investech.adapter.input.dto.decisao;

import com.web.investech.application.domain.model.Proposta;

public record DecisaoResponse(
        String retornoProposta,
        String motivo,
        Double valorAprovado,
        Double quantidadeAprovada,
        String tipoOperacao,
        Proposta proposta
) {}