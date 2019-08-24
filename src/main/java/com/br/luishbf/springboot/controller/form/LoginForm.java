package com.br.luishbf.springboot.controller.form;

<<<<<<< HEAD
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
=======
>>>>>>> 92935389c9562a19d6b26eb0980c3aba0a921db2

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
<<<<<<< HEAD
	public UsernamePasswordAuthenticationToken converter() {
		
		return new UsernamePasswordAuthenticationToken(this.email, this.senha);
	}
=======
>>>>>>> 92935389c9562a19d6b26eb0980c3aba0a921db2
	
	
}
