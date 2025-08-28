package com.smapp.sist_conselhos_rurais.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smapp.sist_conselhos_rurais.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
