package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.PropostaRepository;
import com.web.investech.application.domain.model.Proposta;
import com.web.investech.application.port.PropostaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PropostaAdapter implements PropostaPort {
    private final PropostaRepository repository;

    @Override
    public Proposta registrarProposta(Proposta proposta) {
        return repository.save(proposta);
    }
}
