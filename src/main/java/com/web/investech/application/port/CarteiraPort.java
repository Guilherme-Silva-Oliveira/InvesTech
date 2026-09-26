package com.web.investech.application.port;

import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Conta;

import java.util.Optional;

public interface CarteiraPort {
    Carteira registrarCarteira(Carteira carteira);
    Optional<Carteira> findById(Integer id);
}
