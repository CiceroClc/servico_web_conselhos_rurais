package com.smapp.sist_conselhos_rurais.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smapp.sist_conselhos_rurais.models.Associado;
import com.smapp.sist_conselhos_rurais.repository.AssociadoRepository;

@Service
public class AssociadoService {

	private final AssociadoRepository repo;

    public AssociadoService(AssociadoRepository repo) {
        this.repo = repo;
    }

    public List<Associado> listar() { return repo.findAll(); }
    public Associado salvar(Associado a) { return repo.save(a); }
    public Associado obter(Long id) { return repo.findById(id).orElseThrow(); }
    public void deletar(Long id) { repo.deleteById(id); }
}
