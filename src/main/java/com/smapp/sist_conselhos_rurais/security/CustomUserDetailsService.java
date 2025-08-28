package com.smapp.sist_conselhos_rurais.security;


import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.smapp.sist_conselhos_rurais.models.Usuario;
import com.smapp.sist_conselhos_rurais.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final UsuarioRepository repository;

    public CustomUserDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        String role = "ROLE_" + u.getPerfil().getNome().toUpperCase();
        return User.builder()
                .username(u.getLogin())
                .password(u.getSenhaHash())
                .roles(u.getPerfil().getNome().toUpperCase()) // ex: ROLE_ASSOCIADO
                .build();
    }
	
}
