package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.CarteiraRepository;
import com.web.investech.adapter.output.repository.DecisaoRepository;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Decisao;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.DecisaoPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class DecisaoAdapter implements DecisaoPort {
    private final DecisaoRepository repository;

    @Override
    public Decisao registrarDecisao(Decisao decisao) {
        return repository.save(decisao);
    }

    @Override
    public Optional<Decisao> findById(Integer id) {
        return repository.findById(id);
    }
}
