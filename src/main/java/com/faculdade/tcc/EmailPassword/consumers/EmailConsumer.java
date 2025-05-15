package com.faculdade.tcc.EmailPassword.consumers;

import com.faculdade.tcc.EmailPassword.domain.Email;
import com.faculdade.tcc.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload Email email){
        emailService.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail());
    }
}
