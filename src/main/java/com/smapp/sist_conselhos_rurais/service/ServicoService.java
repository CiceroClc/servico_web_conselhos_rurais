package com.smapp.sist_conselhos_rurais.service;

import com.smapp.sist_conselhos_rurais.models.Servico;
import com.smapp.sist_conselhos_rurais.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServicoService {

    private final ServicoRepository repo;

    public ServicoService(ServicoRepository repo) {
        this.repo = repo;
    }

    public List<Servico> listar(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            return repo.findByNomeContainingIgnoreCase(nome);
        }
        return repo.findAll();
    }

    public Servico obter(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Serviço não encontrado com o id: " + id));
    }

    public Servico salvar(Servico servico) {
        return repo.save(servico);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Serviço não encontrado com o id: " + id);
        }
        repo.deleteById(id);
    }
}