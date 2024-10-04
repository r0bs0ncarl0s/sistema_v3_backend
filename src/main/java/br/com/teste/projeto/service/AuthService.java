package br.com.teste.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.teste.projeto.dto.AcessDTO;
import br.com.teste.projeto.dto.AuthenticationDTO;
import br.com.teste.projeto.dto.UsuarioDTO;
import br.com.teste.projeto.entity.UsuarioEntity;
import br.com.teste.projeto.repository.UsuarioRepository;
import br.com.teste.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticatioManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public AcessDTO login(AuthenticationDTO authDto) {
		
		try {
		//Cria mecanismo de credencial para o spring
		UsernamePasswordAuthenticationToken userAuth = 
				new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		
		//Prepara mecanismo para autenticacao
		Authentication authentication = authenticatioManager.authenticate(userAuth);
		
		//Busca usuario logado
		UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();
		
		String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
		
		Optional<UsuarioEntity> usu = usuarioRepository.findById(userAuthenticate.getId());
		UsuarioDTO usuarioDTO = new UsuarioDTO(usu.get());
		AcessDTO accessDto = new AcessDTO(usuarioDTO.getNome(),token);
		
		return accessDto;
		
		}catch(BadCredentialsException e) {
			//TODO LOGIN OU SENHA INVALIDO
		}
		throw new BadCredentialsException("Acesso negado");
		//return new AcessDTO("Acesso negado");
	}
}
