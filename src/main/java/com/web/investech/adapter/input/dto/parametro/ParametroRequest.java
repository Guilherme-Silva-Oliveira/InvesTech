package com.web.investech.adapter.input.dto.parametro;

import java.time.LocalDateTime;

public record ParametroRequest(
        Double quantidadeMaxima,
        Double precoMinimo,
        Double precoMaximo,
        String ativoNome,
        String tipoAtivo,
        Integer carteiraId
) {
}