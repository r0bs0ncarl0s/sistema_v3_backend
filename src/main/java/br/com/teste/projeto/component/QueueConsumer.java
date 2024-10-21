package br.com.teste.projeto.component;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.teste.exception.BusinessException;
import br.com.teste.projeto.controller.RabbitMQController;
import br.com.teste.projeto.dto.EmailDTO;

@Component
public class QueueConsumer {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private RabbitMQController rabbitMQController;
		
	@Value("${spring.mail.username}")
	private String remetente;
		
/*    @RabbitListener(queues = {"${rabbitmq.queue.email}"})
    public void receive(@Payload Message message) throws BusinessException {
        System.out.println("Message " + message + "  " + LocalDateTime.now());
        String ultima = String.valueOf(message.getHeaders().get("ultima"));
        if(ultima.equals("sim")){
            System.out.println(ultima);
        }
        String payload = String.valueOf(message.getPayload());
        if(payload.equals(1)) {
            throw new BusinessException("testando a excecao");
        }
    }

    @RabbitListener(queues = {"${rabbitmq.queue.log}"})
    public void registrarLog(@Payload String log) throws BusinessException {
        System.out.println("MESSAGE : " + log + "  " + LocalDateTime.now());
    }
    
	@RabbitListener(queues = {"${rabbitmq.queue.email}"})
	public void enviarEmailTexto(@Payload EmailDTO email) throws Exception {		
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(remetente);
			simpleMailMessage.setTo(email.getEmailDestino());
			simpleMailMessage.setSubject(email.getTitulo());
			simpleMailMessage.setText(email.getMensagem());
			//javaMailSender.send(simpleMailMessage);
			//System.out.println(""Email enviado com sucesso para " +  email.getEmailDestino() + " às " + LocalDateTime.now() + " TÍTULO: " + email.getTitulo() + " MENSAGEM: " + email.getMensagem()");
			rabbitMQController.registrarLog("Email enviado com sucesso para " +  email.getEmailDestino() + " às " + LocalDateTime.now() + " TÍTULO: " + email.getTitulo() + " MENSAGEM: " + email.getMensagem());
		}catch(Exception e) {
			//return "Erro ao tentar enviar email " + e.getLocalizedMessage();
			//System.out.println("Ocorreu um erro às "  + LocalDateTime.now() + " ao tentar enviar o email para a caixa postal " + email.getEmailDestino());
			rabbitMQController.registrarError("Ocorreu um erro às "  + LocalDateTime.now() + " ao tentar enviar o email para a caixa postal " + email.getEmailDestino());
		}
	}
*/    
}