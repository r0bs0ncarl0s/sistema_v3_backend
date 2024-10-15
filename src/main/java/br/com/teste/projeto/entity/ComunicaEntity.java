package br.com.teste.projeto.entity;

import java.time.Instant;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.teste.projeto.dto.ComunicaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "RCF_COMUNICA")
public class ComunicaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rcf_comunica_seq")
	@SequenceGenerator(name="rcf_comunica_seq", sequenceName="rcf_comunica_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(name="dt_cadastro", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant dataCadastro;
	
	public ComunicaEntity(ComunicaDTO comunica) {
		BeanUtils.copyProperties(comunica, this);
	}
	
	public ComunicaEntity() {
		
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComunicaEntity other = (ComunicaEntity) obj;
		return Objects.equals(id, other.id);
	}	
}
