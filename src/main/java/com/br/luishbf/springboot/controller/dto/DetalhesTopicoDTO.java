package com.br.luishbf.springboot.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.br.luishbf.springboot.model.StatusTopico;
import com.br.luishbf.springboot.model.Topico;

public class DetalhesTopicoDTO {

	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDTO> respostas;
	
	public DetalhesTopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
	}
	
	
	public String getNomeAutor() {
		return nomeAutor;
	}


	public StatusTopico getStatus() {
		return status;
	}


	public List<RespostaDTO> getRespostas() {
		return respostas;
	}


	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

}
