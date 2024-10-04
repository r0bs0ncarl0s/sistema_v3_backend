package br.com.teste.projeto.dto;

import java.time.Instant;

import org.springframework.beans.BeanUtils;

import br.com.teste.projeto.entity.ComunicaEntity;

public class ComunicaDTO {

	private Long id;	
	private String titulo;	
	private String descricao;	
	private Instant dataCadastro;
	
	public ComunicaDTO(ComunicaEntity comunica) {
		BeanUtils.copyProperties(comunica, this);
	}
	
	public ComunicaDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
