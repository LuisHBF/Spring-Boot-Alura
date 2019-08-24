package com.br.luishbf.springboot.controller;

import javax.validation.Valid;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
=======
import org.springframework.http.ResponseEntity;
>>>>>>> 92935389c9562a19d6b26eb0980c3aba0a921db2
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.br.luishbf.springboot.config.security.TokenService;
=======
>>>>>>> 92935389c9562a19d6b26eb0980c3aba0a921db2
import com.br.luishbf.springboot.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

<<<<<<< HEAD
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		
		try {
			UsernamePasswordAuthenticationToken dadosLogin = form.converter();
			Authentication authentication = this.authManager.authenticate(dadosLogin);
			String token = this.tokenService.gerarToken(authentication);
			System.out.println(token);
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();

=======
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		System.out.println(form.getEmail());
		System.out.println(form.getSenha());
		
		return ResponseEntity.ok().build();
>>>>>>> 92935389c9562a19d6b26eb0980c3aba0a921db2
	}
}
