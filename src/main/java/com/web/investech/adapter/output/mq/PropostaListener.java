package com.web.investech.adapter.output.mq;

import com.web.investech.adapter.input.dto.mq.PropostaMessage;
import com.web.investech.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaListener {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_PROPOSTA, messageConverter = "jsonConverter")
    public void listenProposta(
            PropostaMessage message
    ) {
        System.out.printf("""
                Mensagem Recebida!!
                Operação: %s
                Nome: %s
                """.formatted(message.tipoOperacao(), message.tipoAtivo()));

    }
}
