package br.com.teste.projeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.teste.projeto.entity.PermissaoPerfilRecursoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDTO {
	
	private Long id;
	private PerfilDTO perfil;	
	private RecursoDTO recurso;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PerfilDTO getPerfil() {
		return perfil;
	}


	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}


	public RecursoDTO getRecurso() {
		return recurso;
	}


	public void setRecurso(RecursoDTO recurso) {
		this.recurso = recurso;
	}


	public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
		BeanUtils.copyProperties(permissaoPerfilRecurso, this);
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.recurso = new RecursoDTO(permissaoPerfilRecurso.getRecurso());
		}
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
			this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfil());
		}		
	}
}
