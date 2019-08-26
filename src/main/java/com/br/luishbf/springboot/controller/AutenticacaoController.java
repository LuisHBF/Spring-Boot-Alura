package com.br.luishbf.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.luishbf.springboot.config.security.TokenService;
import com.br.luishbf.springboot.controller.dto.TokenDTO;
import com.br.luishbf.springboot.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form) {

		try {
			UsernamePasswordAuthenticationToken dadosLogin = form.converter();
			Authentication authentication = this.authManager.authenticate(dadosLogin);
			String token = this.tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
