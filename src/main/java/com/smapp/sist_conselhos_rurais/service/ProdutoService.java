package com.smapp.sist_conselhos_rurais.service;

import com.smapp.sist_conselhos_rurais.models.Produto;
import com.smapp.sist_conselhos_rurais.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoService {

    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public List<Produto> listar(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            return repo.findByNomeContainingIgnoreCase(nome);
        }
        return repo.findAll();
    }

    public Produto obter(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado com o id: " + id));
    }

    public Produto salvar(Produto produto) {
        return repo.save(produto);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Produto não encontrado com o id: " + id);
        }
        repo.deleteById(id);
    }
}