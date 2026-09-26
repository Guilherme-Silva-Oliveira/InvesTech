package com.web.investech.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_PROPOSTA = "exchange_proposta";
    public static final String QUEUE_PROPOSTA = "queue_proposta";
    public static final String ROUTING_KEY = "routing_key_proposta";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_PROPOSTA);
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable(QUEUE_PROPOSTA).build();
    }

    @Bean
    public Binding binding(Queue queueProposta, DirectExchange exchangeProposta) {
        return BindingBuilder.bind(queueProposta)
                .to(exchangeProposta)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
