package br.com.teste.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long>{

}
