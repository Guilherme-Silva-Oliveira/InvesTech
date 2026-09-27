package com.web.investech.adapter.input.dto.carteira;

import java.time.LocalDateTime;

public record CarteiraRequest(
        Double saldoDisponivel,
        Double saldoInvestido,
        Double saldoTotal,
        Double lucroRegistrado,
        Double prejuizoRegistrado,
        Integer contaId
) {}