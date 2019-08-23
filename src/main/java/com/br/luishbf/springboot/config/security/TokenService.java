package com.br.luishbf.springboot.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.br.luishbf.springboot.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {



	private static final String SENHAPI = "UMA SENHA MUITO SEGURA!";
	private static final Long TEMPOJWT = 840000L;

	public String gerarToken(Authentication authentication) {
		Date hoje = new Date();
		Usuario logado = (Usuario) authentication.getPrincipal();
		return Jwts.builder()
				.setIssuer("API do Luizão")
				.setIssuedAt(hoje)
				.setSubject(logado.getId().toString())
				.setExpiration(new Date(hoje.getTime() + TokenService.TEMPOJWT))
				.signWith(SignatureAlgorithm.HS256, TokenService.SENHAPI)
				.compact();
	}
}
