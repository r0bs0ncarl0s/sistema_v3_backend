package br.com.teste.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.projeto.service.UtilsService;

@RestController
@RequestMapping("/utils")
@CrossOrigin
public class UtilsController {

	@Autowired
	private UtilsService utilsService;
	
	@PostMapping(value = "/validarEmail")
	public boolean emailValido(@RequestBody String email){
		return utilsService.isEmail(email);
	}
	
	@PostMapping(value = "/validarCPF")
	public boolean cpfValido(@RequestBody String cpf){
		return utilsService.isCPF(cpf);
	}
	
	@PostMapping(value = "/validarCNPJ")
	public boolean cnpjValido(@RequestBody String cnpj){
		return utilsService.isCNPJ(cnpj);
	}
	
	@PostMapping(value = "/validarNIP")
	public boolean nipValido(@RequestBody String nip){
		return utilsService.isNIP(nip);
	}
}
