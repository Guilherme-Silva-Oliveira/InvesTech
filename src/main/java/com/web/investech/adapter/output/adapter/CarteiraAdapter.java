package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.CarteiraRepository;
import com.web.investech.adapter.output.repository.ContaRepository;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.ContaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CarteiraAdapter implements CarteiraPort {
    private final CarteiraRepository repository;

    @Override
    public Carteira registrarCarteira(Carteira carteira) {
        return repository.save(carteira);
    }

    @Override
    public Optional<Carteira> findById(Integer id) {
        return repository.findById(id);
    }
}
