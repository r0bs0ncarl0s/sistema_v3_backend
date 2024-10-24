package br.com.teste.projeto.entity;

import org.springframework.beans.BeanUtils;

import br.com.teste.projeto.dto.PerfilDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RCF_PERFIL")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rcf_perfil_seq")
	@SequenceGenerator(name="rcf_perfil_seq", sequenceName="rcf_perfil_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	public PerfilEntity(PerfilDTO perfil) {
		BeanUtils.copyProperties(perfil, this);
	}
}
