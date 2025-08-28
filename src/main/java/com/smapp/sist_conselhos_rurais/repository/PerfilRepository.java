package com.smapp.sist_conselhos_rurais.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smapp.sist_conselhos_rurais.models.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findByNome(String nome);
}
