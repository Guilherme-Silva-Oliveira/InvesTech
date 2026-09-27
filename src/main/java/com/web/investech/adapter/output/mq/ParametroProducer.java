package com.web.investech.adapter.output.mq;

import com.web.investech.application.domain.model.Parametro;
import com.web.investech.config.RabbitMQConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParametroProducer {
    private final RabbitTemplate rabbitTemplate;

    public void send(Parametro parametro){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_PARAMETRO,
                RabbitMQConfig.ROUTING_KEY_PARAMETRO,
                parametro
        );
        System.out.println("Parâmetro Enviado!!");
    }
}
