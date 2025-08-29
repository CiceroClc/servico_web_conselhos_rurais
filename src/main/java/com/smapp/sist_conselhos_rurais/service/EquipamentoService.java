package com.smapp.sist_conselhos_rurais.service;

import com.smapp.sist_conselhos_rurais.models.Equipamento;
import com.smapp.sist_conselhos_rurais.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repo;

    public EquipamentoService(EquipamentoRepository repo) {
        this.repo = repo;
    }

    public List<Equipamento> listar(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            return repo.findByNomeContainingIgnoreCase(nome);
        }
        return repo.findAll();
    }

    public Equipamento obter(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Equipamento não encontrado com o id: " + id));
    }

    public Equipamento salvar(Equipamento equipamento) {
        return repo.save(equipamento);
    }

    public void deletar(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Equipamento não encontrado com o id: " + id);
        }
        repo.deleteById(id);
    }
}