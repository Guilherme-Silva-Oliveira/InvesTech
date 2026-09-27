package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.ativo.AtivoResponse;
import com.web.investech.adapter.input.dto.parametro.ParametroRequest;
import com.web.investech.adapter.input.dto.parametro.ParametroResponse;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Parametro;

public class ParametroMapper {
    public static Parametro toEntity(ParametroRequest request, String tipoAtivo){
        Parametro p = new Parametro();
        p.setAtivoNome(request.ativoNome());
        p.setPrecoMaximo(request.precoMaximo());
        p.setPrecoMinimo(request.precoMinimo());
        p.setQuantidadeMaxima(request.quantidadeMaxima());
        p.setStatusParametro(true);
        p.setTipoAtivo(tipoAtivo);
        return p;
    }

    public static ParametroResponse toResponse(Parametro parametro){
        return new ParametroResponse(
                parametro.getQuantidadeMaxima(),
                parametro.getPrecoMinimo(),
                parametro.getPrecoMaximo(),
                parametro.getAtivoNome(),
                parametro.getTipoAtivo()
        );
    }
}
