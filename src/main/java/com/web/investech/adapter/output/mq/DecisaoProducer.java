package com.web.investech.adapter.output.mq;

import com.web.investech.application.domain.model.Decisao;
import com.web.investech.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DecisaoProducer {
    private final RabbitTemplate rabbitTemplate;

    public void send(Decisao decisao){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_DECISAO,
                RabbitMQConfig.ROUTING_KEY_DECISAO,
                decisao
        );
        System.out.println("Decisão Enviada!!");
    }
}
