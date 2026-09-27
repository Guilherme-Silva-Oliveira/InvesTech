package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.AtivoRepository;
import com.web.investech.adapter.output.repository.OperacaoRepository;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Operacao;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.OperacaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OperacaoAdapter implements OperacaoPort {
    private final OperacaoRepository repository;

    @Override
    public Operacao registrarOperacao(Operacao operacao) {
        return repository.save(operacao);
    }

    @Override
    public Optional<Operacao> findById(Integer id) {
        return repository.findById(id);
    }
}
