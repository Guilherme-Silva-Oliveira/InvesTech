package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.decisao.DecisaoRequest;
import com.web.investech.adapter.input.dto.mapper.DecisaoMapper;
import com.web.investech.adapter.output.mq.DecisaoProducer;
import com.web.investech.application.domain.enums.status.StatusOperacao;
import com.web.investech.application.domain.enums.tipo.TipoOperacao;
import com.web.investech.application.domain.model.*;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
// TODO 1: ADICIONAR LÓGICA DE FILA PARA ENVIAR DECISÃO AO PYTHON
public class DecisaoService {
    private final PropostaPort propostaPort;
    private final CarteiraPort carteiraPort;
    private final DecisaoPort decisaoPort;
    private final AtivoPort ativoPort;
    private final OperacaoPort operacaoPort;
    private final DecisaoProducer producer;

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
            Decisao saved = decisaoPort.registrarDecisao(d);
            producer.send(saved);
            registrarOperacao(saved);

            return saved;

        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }

    public void registrarOperacao(Decisao decisao){
        try {
            Operacao o = new Operacao();
            Ativo ativo = ativoPort.findByNome(decisao.getProposta().getNomeAtivo()).orElseThrow(()-> new EntidadeInvalidaException("Ativo Não Encontrado"));
            o.setAtivo(ativo);
            o.setCarteira(decisao.getCarteira());
            o.setDataOperacao(LocalDateTime.now());
            o.setDecisao(decisao);
            o.setProposta(decisao.getProposta());
            o.setQuantidade(decisao.getProposta().getQuantidadeSugerida());
            o.setStatusOperacao(StatusOperacao.ACEITA.getDescricao());
            o.setTipoOperacao(TipoOperacao.valueOf(decisao.getProposta().getTipoOperacao()).getDescricao());
            o.setValorOperacao(decisao.getValorAprovado());
            operacaoPort.registrarOperacao(o);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }
}
