package com.web.investech.adapter.input.dto.decisao;

import java.time.LocalDateTime;

public record DecisaoRequest(
        String retornoProposta,
        String motivo,
        Double valorAprovado,
        Double quantidadeAprovada,
        String tipoOperacao,
        Integer propostaId,
        Integer carteiraId
) {
}