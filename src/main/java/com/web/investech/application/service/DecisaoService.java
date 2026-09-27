package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.decisao.DecisaoRequest;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.DecisaoMapper;
import com.web.investech.application.domain.enums.status.StatusOperacao;
import com.web.investech.application.domain.enums.tipo.TipoAtivo;
import com.web.investech.application.domain.enums.tipo.TipoOperacao;
import com.web.investech.application.domain.model.*;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.DecisaoPort;
import com.web.investech.application.port.PropostaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
// TODO 1: ADICIONAR LÓGICA DE FILA PARA ENVIAR DECISÃO AO PYTHON
public class DecisaoService {
    private final PropostaPort propostaPort;
    private final CarteiraPort carteiraPort;
    private final DecisaoPort decisaoPort;

    public Decisao registrarDecisao(DecisaoRequest request){
        try {
            if (request == null) {throw new EntidadeInvalidaException("Decisao Não Pode ser Null");}
            String tipoOperacao = TipoOperacao.valueOf(request.tipoOperacao()).getDescricao();
            Decisao d = DecisaoMapper.toEntity(request, tipoOperacao);
            Carteira carteira = carteiraPort.findById(request.carteiraId()).orElseThrow(()-> new EntidadeInvalidaException("Carteira Não Encontrada"));
            Proposta proposta = propostaPort.findById(request.propostaId()).orElseThrow(()-> new EntidadeInvalidaException("Proposta Não Encontrada"));
            d.setCarteira(carteira);
            d.setProposta(proposta);
            d.setDataDecisao(LocalDateTime.now());
            proposta.setStatusProposta(StatusOperacao.ACEITA.getDescricao());
            proposta.setDataRetorno(LocalDateTime.now());
            return decisaoPort.registrarDecisao(d);

        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }
}
