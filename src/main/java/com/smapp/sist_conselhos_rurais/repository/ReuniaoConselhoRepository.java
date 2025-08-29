package com.smapp.sist_conselhos_rurais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smapp.sist_conselhos_rurais.models.ReuniaoConselho;
import java.time.LocalDate;
import java.util.List;

public interface ReuniaoConselhoRepository extends JpaRepository<ReuniaoConselho, Long>{
    List<ReuniaoConselho> findByPautaContainingIgnoreCase(String pauta);
    List<ReuniaoConselho> findByData(LocalDate data);
}