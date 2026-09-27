package com.web.investech.application.port;

import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Parametro;

import java.util.Optional;

public interface ParametroPort {
    Parametro registrarParametro(Parametro parametro);
    Optional<Parametro> findById(Integer id);
}
