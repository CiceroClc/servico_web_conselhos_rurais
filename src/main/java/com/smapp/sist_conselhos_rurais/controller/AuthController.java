package com.smapp.sist_conselhos_rurais.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.record.LoginRequest;
import com.smapp.sist_conselhos_rurais.record.RegisterRequest;
import com.smapp.sist_conselhos_rurais.record.TokenResponse;
import com.smapp.sist_conselhos_rurais.security.JwtUtil;
import com.smapp.sist_conselhos_rurais.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController 
{
	private final AuthenticationManager authManager;
	private final JwtUtil jwt;
	private final UsuarioService usuarioService;
	
	public AuthController(AuthenticationManager am, JwtUtil jwt, UsuarioService us) {
	    this.authManager = am;
	    this.jwt = jwt;
	    this.usuarioService = us;
	}
	
	@PostMapping("/login")
	public TokenResponse login(@RequestBody LoginRequest req) {
	    Authentication auth = authManager.authenticate(
	        new UsernamePasswordAuthenticationToken(req.login(), req.senha())
	    );
	    UserDetails user = (UserDetails) auth.getPrincipal();
	    String role = user.getAuthorities().stream().findFirst().get().getAuthority(); // ex: ROLE_GESTOR
	    String token = jwt.generateToken(user.getUsername(), role);
	    return new TokenResponse(token);
	}
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest req) {
	    usuarioService.registrar(req.login(), req.senha(), req.perfil()); // perfil: ASSOCIADO/PRESIDENTE/GESTOR
	    return "Usuário registrado.";
	}

}
