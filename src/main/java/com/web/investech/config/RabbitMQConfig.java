package com.web.investech.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_PROPOSTA = "exchange_proposta";
    public static final String QUEUE_PROPOSTA = "queue_proposta";
    public static final String ROUTING_KEY_PROPOSTA = "routing_key_proposta";
    public static final String EXCHANGE_PARAMETRO = "exchange_parametro";
    public static final String QUEUE_PARAMETRO = "queue_parametro";
    public static final String ROUTING_KEY_PARAMETRO = "routing_key_parametro";
    public static final String EXCHANGE_DECISAO = "exchange_decisao";
    public static final String QUEUE_DECISAO = "queue_decisao";
    public static final String ROUTING_KEY_DECISAO = "routing_key_decisao";

    @Bean
    public DirectExchange exchangeProposta() {
        return new DirectExchange(EXCHANGE_PROPOSTA);
    }

    @Bean
    public Queue queueProposta() {
        return QueueBuilder
                .durable(QUEUE_PROPOSTA)
                .build();
    }

    @Bean
    public Binding bindingProposta(
            Queue queueProposta,
            DirectExchange exchangeProposta
    ) {
        return BindingBuilder
                .bind(queueProposta)
                .to(exchangeProposta)
                .with(ROUTING_KEY_PROPOSTA);
    }

    @Bean
    public DirectExchange exchangeParametro() {
        return new DirectExchange(EXCHANGE_PARAMETRO);
    }

    @Bean
    public Queue queueParametro() {
        return QueueBuilder
                .durable(QUEUE_PARAMETRO)
                .build();
    }

    @Bean
    public Binding bindingParametro(
            Queue queueParametro,
            DirectExchange exchangeParametro
    ) {
        return BindingBuilder
                .bind(queueParametro)
                .to(exchangeParametro)
                .with(ROUTING_KEY_PARAMETRO);
    }

    @Bean
    public DirectExchange exchangeDecisao() {
        return new DirectExchange(EXCHANGE_DECISAO);
    }

    @Bean
    public Queue queueDecisao() {
        return QueueBuilder
                .durable(QUEUE_DECISAO)
                .build();
    }

    @Bean
    public Binding bindingDecisao(
            Queue queueDecisao,
            DirectExchange exchangeDecisao
    ) {
        return BindingBuilder
                .bind(queueDecisao)
                .to(exchangeDecisao)
                .with(ROUTING_KEY_DECISAO);
    }

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }
}