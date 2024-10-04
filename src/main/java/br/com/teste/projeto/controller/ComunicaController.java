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

import br.com.teste.projeto.dto.ComunicaDTO;
import br.com.teste.projeto.service.ComunicaService;

@RestController
@RequestMapping(value = "/comunica")
@CrossOrigin
public class ComunicaController {

	@Autowired
	private ComunicaService comunicaService;
	
	@GetMapping
	public List<ComunicaDTO> listarTodos(){
		return comunicaService.listarTodos();
	}

	@PostMapping
	public void inserir(@RequestBody ComunicaDTO comunica) {
		comunicaService.inserir(comunica);
	}
	
	@PutMapping
	public ComunicaDTO alterar(@RequestBody ComunicaDTO comunica) {
		return comunicaService.alterar(comunica);
	}
	
	//http://endereco/usuario/3
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		comunicaService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
