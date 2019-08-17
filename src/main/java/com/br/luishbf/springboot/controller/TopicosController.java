package com.br.luishbf.springboot.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.luishbf.springboot.controller.dto.TopicoDTO;
import com.br.luishbf.springboot.model.Curso;
import com.br.luishbf.springboot.model.Topico;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDTO> lista(){
		Topico topico = new Topico("Dúvida","Duvida com Spring", new Curso("Spring","Programação"));
		
		return TopicoDTO.converter(Arrays.asList(topico,topico,topico));
	}
	
}
