package com.smapp.sist_conselhos_rurais.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import com.smapp.sist_conselhos_rurais.models.Associado;
import com.smapp.sist_conselhos_rurais.repository.AssociadoRepository;

@Service
public class AssociadoService {

	private final AssociadoRepository repo;

    public AssociadoService(AssociadoRepository repo) {
        this.repo = repo;
    }

    public List<Associado> listar(String nome, String cpf) {
        if (nome != null && !nome.trim().isEmpty()) {
            return repo.findByNomeContainingIgnoreCase(nome);
        }
        if (cpf != null && !cpf.trim().isEmpty()) {
            return repo.findByCpfContaining(cpf);
        }
        return repo.findAll();
    }

    public Associado salvar(Associado a) {
        return repo.save(a);
    }
    
    public Associado obter(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Associado não encontrado com o id: " + id));
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Associado não encontrado com o id: " + id);
        }
        repo.deleteById(id);
    }
}