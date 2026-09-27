package com.web.investech.adapter.input.controller;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.ativo.AtivoResponse;
import com.web.investech.adapter.input.dto.carteira.CarteiraRequest;
import com.web.investech.adapter.input.dto.carteira.CarteiraResponse;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.CarteiraMapper;
import com.web.investech.application.service.AtivoService;
import com.web.investech.application.service.CarteiraService;
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
@RequestMapping("/v1/ativos")
@AllArgsConstructor
public class AtivoController {
    private final AtivoService service;

    @Operation(summary = "Cadastrar um Ativo")
    @ApiResponses({
            @ApiResponse(responseCode = "400",description = "Corpo para Cadastro Inválido"),
            @ApiResponse(responseCode = "201",description = "Ativo Cadastrado")
    })
    @PostMapping
    public ResponseEntity<AtivoResponse> cadastrarAtivo(@RequestBody AtivoRequest request){
        var ativo = service.registrarAtivo(request);
        return ResponseEntity.status(201).body(AtivoMapper.toResponse(ativo));
    }
}
