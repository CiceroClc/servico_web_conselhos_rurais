package com.smapp.sist_conselhos_rurais.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smapp.sist_conselhos_rurais.models.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long>{
    List<Associado> findByNomeContainingIgnoreCase(String nome);
    List<Associado> findByCpfContaining(String cpf);
}