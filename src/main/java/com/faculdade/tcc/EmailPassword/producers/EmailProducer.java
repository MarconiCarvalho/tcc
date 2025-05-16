package com.faculdade.tcc.EmailPassword.producers;

import com.faculdade.tcc.EmailPassword.domain.Email;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    public void publishMessage(Email email){rabbitTemplate.convertAndSend(queue, email);}
}
