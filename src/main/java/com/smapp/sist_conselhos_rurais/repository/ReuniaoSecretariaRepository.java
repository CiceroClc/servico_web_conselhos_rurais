package com.smapp.sist_conselhos_rurais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smapp.sist_conselhos_rurais.models.ReuniaoSecretaria;
import java.time.LocalDate;
import java.util.List;

public interface ReuniaoSecretariaRepository extends JpaRepository<ReuniaoSecretaria, Long> {
    List<ReuniaoSecretaria> findByPautaContainingIgnoreCase(String pauta);
    List<ReuniaoSecretaria> findByData(LocalDate data);
}