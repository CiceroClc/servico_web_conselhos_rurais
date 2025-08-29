package com.smapp.sist_conselhos_rurais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smapp.sist_conselhos_rurais.models.Servico;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
    List<Servico> findByNomeContainingIgnoreCase(String nome);
}