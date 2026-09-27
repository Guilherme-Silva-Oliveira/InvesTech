package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.ativo.AtivoResponse;
import com.web.investech.adapter.input.dto.decisao.DecisaoRequest;
import com.web.investech.adapter.input.dto.decisao.DecisaoResponse;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Decisao;

public class DecisaoMapper {
    public static Decisao toEntity(DecisaoRequest request, String tipoOperacao){
        Decisao d = new Decisao();
        d.setTipoOperacao(tipoOperacao);
        d.setQuantidadeAprovada(request.quantidadeAprovada());
        d.setRetornoProposta(request.retornoProposta());
        d.setMotivo(request.motivo());
        d.setValorAprovado(request.valorAprovado());
        return d;
    }

    public static DecisaoResponse toResponse(Decisao decisao){
        return new DecisaoResponse(
                decisao.getRetornoProposta(),
                decisao.getMotivo(),
                decisao.getValorAprovado(),
                decisao.getQuantidadeAprovada(),
                decisao.getTipoOperacao(),
                decisao.getProposta()
        );
    }
}
