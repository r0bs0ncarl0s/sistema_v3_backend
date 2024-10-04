package br.com.teste.projeto.controller;

import java.util.List;

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

import br.com.teste.projeto.dto.UsuarioDTO;
import br.com.teste.projeto.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioDTO> listarTodos(){
		return usuarioService.listarTodos();
	}

	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuario) throws Exception {
		if(usuarioValido(usuario)) {
			usuarioService.inserir(usuario);
		}else { 
			throw new Exception("Informações obrigatórias não preenchidas.");
		}
	}
	
	@PutMapping
	public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) throws Exception {
		if(usuarioValido(usuario)) {
			return usuarioService.alterar(usuario);
		}else { 
			throw new Exception("Informações obrigatórias não preenchidas.");
		}
	}
	
	//http://endereco/usuario/3
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		usuarioService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO buscarPorId(@PathVariable("id") Long id){
		return usuarioService.buscarPorId(id);
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
