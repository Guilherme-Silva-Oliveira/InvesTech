package com.web.investech.adapter.input.dto.parametro;

public record ParametroResponse(
        Double quantidadeMaxima,
        Double precoMinimo,
        Double precoMaximo,
        String ativoNome,
        String tipoAtivo
) {}