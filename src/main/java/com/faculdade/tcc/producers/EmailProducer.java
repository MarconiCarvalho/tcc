package com.faculdade.tcc.producers;

import com.faculdade.tcc.domain.email.Email;
import com.faculdade.tcc.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.account-created}")
    public void listenAccountCreated(@Payload Email email){
        emailService.sendEmail(email);
        System.out.println("Account Created Email Status: " + email.getStatusEmail());
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.password-reset}")
    public void listenPasswordReset(@Payload Email email){
        emailService.sendEmail(email);
        System.out.println("Password Reset Email Status: " + email.getStatusEmail());
    }
}
