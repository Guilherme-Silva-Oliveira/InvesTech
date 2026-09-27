package com.web.investech.adapter.output.mq;

import com.web.investech.adapter.input.dto.mq.PropostaMessage;
import com.web.investech.application.service.PropostaService;
import com.web.investech.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

// TODO 1: Trocar Sout por Logger
public class PropostaListener {
    private final PropostaService service;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PROPOSTA, messageConverter = "jsonConverter")
    public void listenProposta(
            PropostaMessage message
    ) {
        System.out.printf("""
                Mensagem Recebida!!
                Operação: %s
                Nome: %s
                """.formatted(message.tipoOperacao(), message.tipoAtivo()));
        service.processarProposta(message);
    }
}
