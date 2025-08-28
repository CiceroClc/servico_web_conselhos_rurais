package com.smapp.sist_conselhos_rurais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smapp.sist_conselhos_rurais.models.PresencaReuniaoSecretaria;
import com.smapp.sist_conselhos_rurais.models.PresencaReuniaoSecretariaId;

public interface PresencaReuniaoSecretariaRepository
		extends JpaRepository<PresencaReuniaoSecretaria, PresencaReuniaoSecretariaId> {

}
