package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.conta.ContaRequest;
import com.web.investech.adapter.input.dto.conta.ContaResponse;
import com.web.investech.adapter.input.dto.usuario.UsuarioRequest;
import com.web.investech.adapter.input.dto.usuario.UsuarioResponse;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.domain.model.Usuario;

public class ContaMapper {
    public static Conta toEntity(ContaRequest request){
        Conta c = new Conta();
        c.setMoedaBase(request.moedaBase());
        c.setCentroOperacao(request.centroOperacao());
        return c;
    }

    public static ContaResponse toResponse(Conta conta){
        return new ContaResponse(
                conta.getMoedaBase(),
                conta.getCentroOperacao(),
                conta.getUsuario().getNome()
        );
    }
}
