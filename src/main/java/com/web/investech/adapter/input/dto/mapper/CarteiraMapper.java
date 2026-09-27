package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.carteira.CarteiraRequest;
import com.web.investech.adapter.input.dto.carteira.CarteiraResponse;
import com.web.investech.adapter.input.dto.conta.ContaRequest;
import com.web.investech.adapter.input.dto.conta.ContaResponse;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Conta;

public class CarteiraMapper {
    public static Carteira toEntity(CarteiraRequest request){
        Carteira c = new Carteira();
        c.setSaldoDisponivel(request.saldoDisponivel());
        c.setSaldoInvestido(request.saldoInvestido());
        c.setSaldoTotal(request.saldoTotal());
        c.setLucroRegistrado(request.lucroRegistrado());
        c.setPrejuizoRegistrado(request.prejuizoRegistrado());
        return c;
    }

    public static CarteiraResponse toResponse(Carteira carteira){
        return new CarteiraResponse(
                carteira.getSaldoDisponivel(),
                carteira.getSaldoInvestido(),
                carteira.getSaldoTotal(),
                carteira.getLucroRegistrado(),
                carteira.getPrejuizoRegistrado(),
                carteira.getConta().getUsuario().getNome()
        );
    }
}
