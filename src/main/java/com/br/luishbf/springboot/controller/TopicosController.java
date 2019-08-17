package com.br.luishbf.springboot.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.luishbf.springboot.controller.dto.TopicoDTO;
import com.br.luishbf.springboot.model.Topico;
import com.br.luishbf.springboot.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDTO> lista(){
		List<Topico> topicos = this.topicoRepository.findAll();
		return TopicoDTO.converter(topicos);
	}
	
}
