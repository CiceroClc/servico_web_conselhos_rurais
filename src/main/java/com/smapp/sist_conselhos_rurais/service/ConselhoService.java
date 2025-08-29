package com.smapp.sist_conselhos_rurais.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import com.smapp.sist_conselhos_rurais.models.Conselho;
import com.smapp.sist_conselhos_rurais.repository.ConselhoRepository;

@Service
public class ConselhoService {

    private final ConselhoRepository repo;

    public ConselhoService(ConselhoRepository repo) {
        this.repo = repo;
    }

    public List<Conselho> listar(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return repo.findAll();
        }
        return repo.findByNomeContainingIgnoreCase(nome);
    }

    public Conselho salvar(Conselho c) {
        return repo.save(c);
    }

    public Conselho obter(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conselho não encontrado com o id: " + id));
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Conselho não encontrado com o id: " + id);
        }
        repo.deleteById(id);
    }
}