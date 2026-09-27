package com.web.investech.adapter.input.controller;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.ativo.AtivoResponse;
import com.web.investech.adapter.input.dto.decisao.DecisaoRequest;
import com.web.investech.adapter.input.dto.decisao.DecisaoResponse;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.DecisaoMapper;
import com.web.investech.application.service.AtivoService;
import com.web.investech.application.service.DecisaoService;
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
@RequestMapping("/v1/decisoes")
@AllArgsConstructor
public class DecisaoController {
    private final DecisaoService service;

    @Operation(summary = "Cadastrar uma Decisão")
    @ApiResponses({
            @ApiResponse(responseCode = "400",description = "Corpo para Cadastro Inválido"),
            @ApiResponse(responseCode = "201",description = "Decisão Cadastrada")
    })
    @PostMapping
    public ResponseEntity<DecisaoResponse> cadastrarDecisao(@RequestBody DecisaoRequest request){
        var decisao = service.registrarDecisao(request);
        return ResponseEntity.status(201).body(DecisaoMapper.toResponse(decisao));
    }
}
