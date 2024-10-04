package br.com.teste.projeto.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teste.projeto.dto.ComunicaDTO;
import br.com.teste.projeto.entity.ComunicaEntity;
import br.com.teste.projeto.repository.ComunicaRepository;

@Service
public class ComunicaService {

	@Autowired
	private ComunicaRepository comunicaRepository;
	
	public List<ComunicaDTO> listarTodos(){
		List<ComunicaEntity> Comunicas = comunicaRepository.findAll();
		return Comunicas.stream().map(ComunicaDTO::new).toList();
	}
	
	public void inserir(ComunicaDTO Comunica) {
		ComunicaEntity comunicaEntity = new ComunicaEntity(Comunica);
		comunicaEntity.setId(null);
		comunicaEntity.setDataCadastro(Instant.now());
		comunicaRepository.save(comunicaEntity);
	}
	
	public void inserirNovoComunica(ComunicaDTO comunica) {
		ComunicaEntity comunicaEntity = new ComunicaEntity(comunica);
		comunicaEntity.setId(null);
		comunicaEntity.setDataCadastro(Instant.now());
		comunicaRepository.save(comunicaEntity);
	}

	public ComunicaDTO alterar(ComunicaDTO comunica) {
		ComunicaEntity comunicaEntity = new ComunicaEntity(comunica);
		comunicaEntity.setDataCadastro(Instant.now());
		return new ComunicaDTO(comunicaRepository.save(comunicaEntity));
	}
	
	public void excluir(Long id) {
		ComunicaEntity comunica = comunicaRepository.findById(id).get();
		comunicaRepository.delete(comunica);
	}
	
	public ComunicaDTO buscarPorId(Long id) {
		return new ComunicaDTO(comunicaRepository.findById(id).get());
	}
}
