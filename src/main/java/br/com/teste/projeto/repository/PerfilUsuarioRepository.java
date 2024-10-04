package br.com.teste.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.projeto.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long>{

}
