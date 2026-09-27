package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.MovimentacaoMapper;
import com.web.investech.adapter.input.dto.movimentacao.MovimentacaoRequest;
import com.web.investech.application.domain.enums.status.StatusMovimentacao;
import com.web.investech.application.domain.enums.tipo.TipoAtivo;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Movimentacao;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.MovimentacaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class MovimentacaoService {
    private final MovimentacaoPort movimentacaoPort;
    private final CarteiraPort carteiraPort;

    public Movimentacao registrarMovimentacao(MovimentacaoRequest request){
        try {
            if (request == null) {throw new EntidadeInvalidaException("Conta Não Pode ser Null");}
            Carteira carteira = carteiraPort.findById(request.carteiraId()).orElseThrow(()-> new EntidadeInvalidaException("Carteira Não Encontrada"));
            Movimentacao m = MovimentacaoMapper.toEntity(request);
            carteira.setSaldoDisponivel(carteira.getSaldoDisponivel() + m.getValor());
            carteira.setSaldoTotal(carteira.getSaldoDisponivel() + carteira.getSaldoInvestido());
            m.setDataMovimentacao(LocalDateTime.now());
            m.setStatusMovimentacao(StatusMovimentacao.RECEBIDA.getDescricao());
            m.setCarteira(carteira);
            return movimentacaoPort.registrarMovimentacao(m);

        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }
}
