package com.web.investech.adapter.input.dto.movimentacao;

import java.time.LocalDateTime;

public record MovimentacaoRequest(
        Double valor,
        String descricao,
        Integer carteiraId
) {}