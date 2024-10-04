package br.com.teste.projeto.dto;

public class AcessDTO {

	private String token;
	private String nome_usuario;

	//TODO implementar retornar o usuario e liberacoes (authorities)
	
	public AcessDTO(String nome_usuario, String token) {
		super();
		this.nome_usuario = nome_usuario;
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}	
}
