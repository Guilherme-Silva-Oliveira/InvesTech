package com.web.investech.adapter.input.controller;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.ativo.AtivoResponse;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.ParametroMapper;
import com.web.investech.adapter.input.dto.parametro.ParametroRequest;
import com.web.investech.adapter.input.dto.parametro.ParametroResponse;
import com.web.investech.application.service.AtivoService;
import com.web.investech.application.service.ParametroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/parametros")
@AllArgsConstructor
public class ParametroController {
    private final ParametroService service;

    @Operation(summary = "Cadastrar um Parametro")
    @ApiResponses({
            @ApiResponse(responseCode = "400",description = "Corpo para Cadastro Inválido"),
            @ApiResponse(responseCode = "201",description = "Parametro Cadastrado")
    })
    @PostMapping
    public ResponseEntity<ParametroResponse> cadastrarParametro(@RequestBody ParametroRequest request){
        var parametro = service.registrarParametro(request);
        return ResponseEntity.status(201).body(ParametroMapper.toResponse(parametro));
    }
}
