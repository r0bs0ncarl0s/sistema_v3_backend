package br.com.teste.projeto.controller;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.projeto.dto.EmailDTO;
import br.com.teste.projeto.dto.UsuarioDTO;
import br.com.teste.projeto.service.UsuarioService;
import br.com.teste.utils.Constantes;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RabbitMQController rabbitMQController;
	
	@GetMapping
	public List<UsuarioDTO> listarTodos(){
		return usuarioService.listarTodos();
	}

   // private final AmqpTemplate queueSender;

	/*public UsuarioController(AmqpTemplate queueSender) {
        this.queueSender = queueSender;
    }*/
    
	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuario) throws Exception {
		try {
			if(usuarioValido(usuario)) {
				String msg = usuarioService.inserir(usuario);
				if(msg!=null && msg.equals(Constantes.MSG_SUCESSO)) {
					rabbitMQController.enviarEmail(new EmailDTO(usuario.getEmail(), "Novo Usuário", "O usuário " + usuario.getLogin() +  " foi inserido com sucesso!"));
				}else {
					rabbitMQController.registrarError(msg);
				}
			} /*else { String msg = "Informações obrigatórias não preenchidas.";
				 rabbitMQController.publicarMsgErro(msg); throw new Exception(msg); }*/
		} catch (Exception e) { 
			rabbitMQController.registrarError(e.getMessage());
			throw new Exception(e.getMessage()); 
		}			
	}
	
	@PutMapping
	public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) throws Exception {
		try {
			if(usuarioValido(usuario)) {
				usuario = usuarioService.alterar(usuario);
				//rabbitMQController.publicarMsgUsuario(usuario, TipoAcaoBancoDados.ALTERAR);
			}else { 
				rabbitMQController.registrarError("Informações obrigatórias não preenchidas.");
			}
		} catch (Exception e) {
			rabbitMQController.registrarError(e.getMessage());
			throw new Exception(e.getMessage());
		}	
		return usuario;
	}
	
	//http://endereco/usuario/3
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws Exception{
		try {
			UsuarioDTO usuario = usuarioService.buscarPorId(id);
			usuarioService.excluir(id);
			//rabbitMQController.publicarMsgUsuario(usuario, TipoAcaoBancoDados.EXCLUIR);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			rabbitMQController.registrarError(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO buscarPorId(@PathVariable("id") Long id) throws Exception{
		try {
			return usuarioService.buscarPorId(id);
		} catch (Exception e) {
			rabbitMQController.registrarError(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	private boolean usuarioValido(UsuarioDTO usuario) {
		if(usuario!=null) {
			if( (usuario.getLogin()==null || usuario.getLogin().trim().equals("")) 
				|| 
				(usuario.getNome()==null  || usuario.getNome().trim().equals(""))
				|| 
				(usuario.getSenha()==null || usuario.getSenha().trim().equals(""))
				||
				(usuario.getEmail()==null || usuario.getEmail().trim().equals(""))
				|| 
				(usuario.getSituacao()==null)) {
				return false;
			}else {
				return true;
			}
		}	
		return false;
	}
}
