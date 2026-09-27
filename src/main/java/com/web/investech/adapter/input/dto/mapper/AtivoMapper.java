package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.ativo.AtivoResponse;
import com.web.investech.adapter.input.dto.carteira.CarteiraRequest;
import com.web.investech.adapter.input.dto.carteira.CarteiraResponse;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;

public class AtivoMapper {
    public static Ativo toEntity(AtivoRequest request, String tipoAtivo){
        Ativo a = new Ativo();
        a.setNome(request.nome());
        a.setTipoAtivo(tipoAtivo);
        a.setPrecoAtual(request.precoAtual());
        return a;
    }

    public static AtivoResponse toResponse(Ativo ativo){
        return new AtivoResponse(
                ativo.getNome(),
                ativo.getTipoAtivo(),
                ativo.getPrecoAtual()
        );
    }
}
