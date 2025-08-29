package com.smapp.sist_conselhos_rurais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smapp.sist_conselhos_rurais.models.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}