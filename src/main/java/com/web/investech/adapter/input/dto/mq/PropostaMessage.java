package com.web.investech.adapter.input.dto.mq;

import java.time.LocalDateTime;

public record PropostaMessage (
    String tipoAtivo,
    String nomeAtivo,
    String tipoOperacao,
    Double quantidadeSugerida,
    Double valorSugerido,
    String descricaoProposta,
    Integer nivelRisco
) {}
