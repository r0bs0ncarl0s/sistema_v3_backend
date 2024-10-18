package br.com.teste.projeto.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.teste.projeto.dto.RecursoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "RCF_RECURSO")
public class RecursoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rcf_recurso_seq")
	@SequenceGenerator(name="rcf_recurso_seq", sequenceName="rcf_recurso_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String chave;
	
	public RecursoEntity() {
	
	}

	public RecursoEntity(RecursoDTO recurso) {
		BeanUtils.copyProperties(recurso, this);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
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
		RecursoEntity other = (RecursoEntity) obj;
		return Objects.equals(id, other.id);
	}	
}
