package br.com.teste.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.projeto.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long>{

}
