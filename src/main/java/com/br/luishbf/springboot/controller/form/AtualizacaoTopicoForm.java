package com.br.luishbf.springboot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.br.luishbf.springboot.model.Topico;
import com.br.luishbf.springboot.repository.TopicoRepository;
import com.sun.istack.internal.NotNull;

public class AtualizacaoTopicoForm {

	@NotNull
	@NotEmpty
	@Size(min=5)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Size(min=10)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(this.mensagem);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}
	
	
}
