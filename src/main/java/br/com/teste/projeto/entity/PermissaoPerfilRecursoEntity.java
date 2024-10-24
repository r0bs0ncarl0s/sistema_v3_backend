package br.com.teste.projeto.entity;

import org.springframework.beans.BeanUtils;

import br.com.teste.projeto.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RCF_PERMISSAO_PERFIL_RECURSO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissaoPerfilRecursoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rcf_per_per_rec_seq")
	@SequenceGenerator(name="rcf_per_per_rec_seq", sequenceName="rcf_per_per_rec_id_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfil;
	
	@ManyToOne
	@JoinColumn(name = "ID_RECURSO")
	private RecursoEntity recurso;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}



	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}



	public RecursoEntity getRecurso() {
		return recurso;
	}



	public void setRecurso(RecursoEntity recurso) {
		this.recurso = recurso;
	}



	public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecurso) {
		BeanUtils.copyProperties(permissaoPerfilRecurso, this);
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.recurso = new RecursoEntity(permissaoPerfilRecurso.getRecurso());
		}
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
			this.perfil = new PerfilEntity(permissaoPerfilRecurso.getPerfil());
		}	
	}
}
