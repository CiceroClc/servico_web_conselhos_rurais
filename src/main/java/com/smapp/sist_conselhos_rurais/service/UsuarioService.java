package com.smapp.sist_conselhos_rurais.service;

import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smapp.sist_conselhos_rurais.models.Perfil;
import com.smapp.sist_conselhos_rurais.models.Usuario;
import com.smapp.sist_conselhos_rurais.repository.PerfilRepository;
import com.smapp.sist_conselhos_rurais.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepo;
    private final PerfilRepository perfilRepo;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository u, PerfilRepository p, PasswordEncoder e) {
        this.usuarioRepo = u;
        this.perfilRepo = p;
        this.encoder = e;
    }

    public Usuario registrar(String login, String senha, String nomePerfil) {
        Perfil perfil = perfilRepo.findByNome(nomePerfil)
                .orElseThrow(() -> new NoSuchElementException("Perfil não encontrado: " + nomePerfil));

        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenhaHash(encoder.encode(senha));
        u.setPerfil(perfil);
        return usuarioRepo.save(u);
    }
}
