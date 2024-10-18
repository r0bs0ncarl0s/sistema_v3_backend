package br.com.teste.projeto.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoAcaoBancoDados {

	INCLUIR ("I", "Incluir"),
	ALTERAR ("A","Alterar"),	
	EXCLUIR ("E", "Excluir"),
	LISTAR ("L", "Listar");
	
	private String codigo;
	private String descricao;
	
	private TipoAcaoBancoDados(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@JsonValue
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@JsonCreator
	public static TipoAcaoBancoDados doValor(String codigo) {
		if(codigo.equals("A")) {
			return ALTERAR;
		}else if(codigo.equals("I")) {
			return INCLUIR;
		}else if(codigo.equals("E")) {
			return EXCLUIR;
		}else if(codigo.equals("L")) {
			return LISTAR;
		}else {
			return null;
		}
	}
	
}
