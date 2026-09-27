package com.web.investech.adapter.input.dto.carteira;

public record CarteiraResponse(
        Double saldoDisponivel,
        Double saldoInvestido,
        Double saldoTotal,
        Double lucroRegistrado,
        Double prejuizoRegistrado,
        String usuario
) {}