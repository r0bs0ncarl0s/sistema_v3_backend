package br.com.teste.projeto.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.teste.projeto.dto.EmailDTO;

@Service
public class EnqueueDequeService {
    
    private final AmqpTemplate amqpTemplate;
  
    @Value("${rabbitmq.queue}")
    String queuePrincipal;
    
    @Value("${rabbitmq.queue.log}")
    String queueLog;
    
    @Value("${rabbitmq.queue.email}")
    String queueEmail;

    @Value("${rabbitmq.exchange}")
    String exchangePrincipal;

    @Value("${rabbitmq.routingkey}")
    private String routingkeyPrincipal;

    @Value("${rabbitmq.routingkey.log}")
    private String routingkeyLog;
    
    @Value("${rabbitmq.routingkey.email}")
    private String routingkeyEmail;
    
    public EnqueueDequeService(RabbitTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publicarMensagem(String msg){
        amqpTemplate.convertAndSend(exchangePrincipal,routingkeyPrincipal,msg);
    }
    
    public void registrarLog(String msg){
        amqpTemplate.convertAndSend(exchangePrincipal,routingkeyLog,msg);
    }
    
    public void publicarEmail(EmailDTO emailDTO){
        amqpTemplate.convertAndSend(exchangePrincipal,routingkeyEmail,emailDTO);
    }
}
