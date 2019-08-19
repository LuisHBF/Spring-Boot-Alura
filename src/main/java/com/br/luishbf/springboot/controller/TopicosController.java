package com.br.luishbf.springboot.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.luishbf.springboot.controller.dto.DetalhesTopicoDTO;
import com.br.luishbf.springboot.controller.dto.TopicoDTO;
import com.br.luishbf.springboot.controller.form.TopicoForm;
import com.br.luishbf.springboot.model.Topico;
import com.br.luishbf.springboot.repository.CursoRepository;
import com.br.luishbf.springboot.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDTO> listar(String nomeCurso){
		List<Topico> topicos = nomeCurso == null ? this.topicoRepository.findAll() : this.topicoRepository.findByCursoNome(nomeCurso);
		return TopicoDTO.converter(topicos);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(this.cursoRepository);
		this.topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@GetMapping("/{id}")
	public DetalhesTopicoDTO detalhar(@PathVariable Long id){
		Topico topico = this.topicoRepository.getOne(id);
		return new DetalhesTopicoDTO(topico);
	}
	
}
