package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.AtivoRepository;
import com.web.investech.adapter.output.repository.ParametroRepository;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Parametro;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.ParametroPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ParametroAdapter implements ParametroPort {
    private final ParametroRepository repository;

    @Override
    public Parametro registrarParametro(Parametro parametro) {
        return repository.save(parametro);
    }

    @Override
    public Optional<Parametro> findById(Integer id) {
        return repository.findById(id);
    }
}
