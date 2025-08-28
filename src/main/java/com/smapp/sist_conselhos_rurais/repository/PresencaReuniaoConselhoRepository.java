package com.smapp.sist_conselhos_rurais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smapp.sist_conselhos_rurais.models.PresencaReuniaoConselho;
import com.smapp.sist_conselhos_rurais.models.PresencaReuniaoConselhoId;

public interface PresencaReuniaoConselhoRepository
		extends JpaRepository<PresencaReuniaoConselho, PresencaReuniaoConselhoId> {

}
