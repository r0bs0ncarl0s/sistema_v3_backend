package br.com.teste.projeto.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.teste.projeto.dto.EmailDTO;
import br.com.teste.projeto.security.RabbitMQConfig;
import br.com.teste.projeto.service.EnqueueDequeService;

@RestController
public class RabbitMQController {

    private final EnqueueDequeService enqueueDequeService;
    
    private RabbitMQConfig rabbitMQConfig;
    
    public RabbitMQController(EnqueueDequeService enqueueDequeService) {
        this.enqueueDequeService = enqueueDequeService;
    }

    /*public String publicarMsgUsuario(@RequestBody UsuarioDTO usuarioDTO, TipoAcaoBancoDados acao) {
        String infoUsuario = "Informações do Usuário: NOME:" + usuarioDTO.getNome().concat("  -  EMAIL:").concat(usuarioDTO.getEmail());
        infoUsuario = infoUsuario.concat("  -  MSG:").concat(acao.equals(TipoAcaoBancoDados.INCLUIR)?
        		                                             " Gravado com sucesso!":acao.equals(TipoAcaoBancoDados.ALTERAR)?
		        		                 					 " Alterado com sucesso!":acao.equals(TipoAcaoBancoDados.EXCLUIR)?
		        		                                     " Excluído com sucesso!":"");
        enqueueDequeService.publicarMensagem(infoUsuario);
        return infoUsuario;
    }*/
    
    public void publicarMensagem(String msg) throws Exception {
    	enqueueDequeService.publicarMensagem(msg);
    }
    
    public void registrarError(String msg) throws Exception {
    	//enqueueDequeService.registrarLog("ERROR:" + msg);
    	registrarLog("ERROR: " + msg);
    }

    public void registrarLog(String msg) throws Exception {
    	enqueueDequeService.registrarLog(msg);
    }

    public void enviarEmail(EmailDTO emailDTO) throws Exception {
        enqueueDequeService.publicarEmail(emailDTO);
    }
}
