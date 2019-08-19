package com.br.luishbf.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.luishbf.springboot.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	public List<Topico> findByCursoNome(String nomeCurso);


}
