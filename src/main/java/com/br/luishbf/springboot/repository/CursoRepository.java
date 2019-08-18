package com.br.luishbf.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.luishbf.springboot.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	public Curso findByNome(String nomeCurso);
}
