package br.com.teste.projeto.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.com.teste.projeto.dto.EmailDTO;

@Service
public class EmailService {
/*
	@Autowired
	private JavaMailSender javaMailSender;
		
	@Value("${spring.mail.username}")
	private String remetente;
	
	
	
  	@RabbitListener(queues = {"queue_sistema_v3_email"})
    public void receive(@Payload Message message) {
        String payload = String.valueOf(message.getPayload());
        this.sucessoPagamento(payload);
    }
	
	public void sucessoPagamento(String payload) {
        System.out.println("O pagamento foi confirmado: " + payload);
    }
    
	@RabbitListener(queues = {"queue_sistema_v3_email"})
	public String enviarEmailTexto(@Payload EmailDTO email) {		
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(remetente);
			simpleMailMessage.setTo(email.getEmailDestino());
			simpleMailMessage.setSubject(email.getTitulo());
			simpleMailMessage.setText(email.getMensagem());
			//javaMailSender.send(simpleMailMessage);
			return "Email enviado";
		}catch(Exception e) {
			return "Erro ao tentar enviar email " + e.getLocalizedMessage();
		}
	}
*/	
}
