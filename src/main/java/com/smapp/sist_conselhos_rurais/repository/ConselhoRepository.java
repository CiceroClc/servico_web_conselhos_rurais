package com.smapp.sist_conselhos_rurais.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smapp.sist_conselhos_rurais.models.Conselho;

public interface ConselhoRepository extends JpaRepository<Conselho, Long>{
    List<Conselho> findByNomeContainingIgnoreCase(String nome);
}