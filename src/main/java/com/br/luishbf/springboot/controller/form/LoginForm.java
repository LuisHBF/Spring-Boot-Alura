package com.br.luishbf.springboot.controller.form;


public class LoginForm {

	private String email;
	private String senha;
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	
	
}
