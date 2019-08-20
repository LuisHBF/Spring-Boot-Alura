package com.br.luishbf.springboot.controller;


import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.luishbf.springboot.controller.dto.DetalhesTopicoDTO;
import com.br.luishbf.springboot.controller.dto.TopicoDTO;
import com.br.luishbf.springboot.controller.form.AtualizacaoTopicoForm;
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
	@Cacheable(value = "listaDeTopicos")
	public Page<TopicoDTO> listar(@RequestParam(required = false) String nomeCurso, @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable pageable){
		  Page<Topico> topicos = nomeCurso == null ? this.topicoRepository.findAll(pageable) : this.topicoRepository.findByCursoNome(nomeCurso, pageable);
		  return TopicoDTO.converter(topicos);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true) //limpando cache para permitir que a nova inserção apareça no get do método listar, que está cacheado sem esse novo registro.
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
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Topico topico = form.atualizar(id, this.topicoRepository);
		
		return ResponseEntity.ok(new TopicoDTO(topico));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		this.topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
