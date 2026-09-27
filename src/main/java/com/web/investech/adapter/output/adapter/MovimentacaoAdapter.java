package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.CarteiraRepository;
import com.web.investech.adapter.output.repository.MovimentacaoRepository;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Movimentacao;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.MovimentacaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MovimentacaoAdapter implements MovimentacaoPort {
    private final MovimentacaoRepository repository;

    @Override
    public Movimentacao registrarMovimentacao(Movimentacao movimentacao) {
        return repository.save(movimentacao);
    }

    @Override
    public Optional<Movimentacao> findById(Integer id) {
        return repository.findById(id);
    }
}
