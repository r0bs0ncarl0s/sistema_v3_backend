package br.com.teste.projeto.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RCF_USUARIO_VERIFICADOR")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioVerificadorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private UUID uuid;
	
	@Column(nullable = false)
	private Instant dataExpiracao;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public UUID getUuid() {
		return uuid;
	}



	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}



	public Instant getDataExpiracao() {
		return dataExpiracao;
	}



	public void setDataExpiracao(Instant dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}



	public UsuarioEntity getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}



	@ManyToOne
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID", unique = true)
	private UsuarioEntity usuario;
}
