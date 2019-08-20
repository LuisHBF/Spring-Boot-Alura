package com.br.luishbf.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.luishbf.springboot.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	public Page<Topico> findByCursoNome(String nomeCurso, Pageable pageable);


}
