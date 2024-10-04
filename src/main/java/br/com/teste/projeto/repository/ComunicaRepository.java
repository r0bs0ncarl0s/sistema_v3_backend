package br.com.teste.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.projeto.entity.ComunicaEntity;

public interface ComunicaRepository extends JpaRepository<ComunicaEntity, Long>{

}
