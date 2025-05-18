package com.faculdade.tcc.infra.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigs {

    @Value("${spring.rabbitmq.queue.account-created}")
    private String accountCreatedQueue;

    @Value("${spring.rabbitmq.queue.password-reset}")
    private String passwordResetQueue;

    @Bean
    public Queue accountCreatedQueue() {
        return new Queue(accountCreatedQueue, true);
    }

    @Bean
    public Queue passwordResetQueue() {
        return new Queue(passwordResetQueue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

