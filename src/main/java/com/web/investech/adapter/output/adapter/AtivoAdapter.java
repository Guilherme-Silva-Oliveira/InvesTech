package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.AtivoRepository;
import com.web.investech.adapter.output.repository.CarteiraRepository;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.CarteiraPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AtivoAdapter implements AtivoPort {
    private final AtivoRepository repository;

    @Override
    public Ativo registrarAtivo(Ativo ativo) {
        return repository.save(ativo);
    }

    @Override
    public Optional<Ativo> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Ativo> findByNome(String nome) {
        return repository.findByNome(nome);
    }
}
