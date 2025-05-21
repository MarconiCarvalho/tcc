package com.faculdade.tcc.consumers;

import com.faculdade.tcc.domain.email.Email;
import com.faculdade.tcc.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue.account-created}")
    public void listenAccountCreated(@Payload Email email){
        emailService.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail());
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.password-reset}")
    public void listenPasswordReset(@Payload Email email){
        emailService.sendEmail(email);
        System.out.println("Email Status: " + email.getStatusEmail());
    }

}
