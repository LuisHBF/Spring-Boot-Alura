package com.br.luishbf.springboot.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.luishbf.springboot.model.Usuario;
import com.br.luishbf.springboot.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = this.usuarioRepository.findByEmail(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Dados inválidos");
	}

}
