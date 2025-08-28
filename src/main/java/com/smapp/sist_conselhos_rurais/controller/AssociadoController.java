package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.models.Associado;
import com.smapp.sist_conselhos_rurais.service.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
	
	private final AssociadoService service;
    public AssociadoController(AssociadoService s) { this.service = s; }

    @GetMapping
    public List<Associado> listar() { return service.listar(); }

    @PostMapping
    public Associado criar(@RequestBody Associado a) { return service.salvar(a); }

    @GetMapping("/{id}")
    public Associado obter(@PathVariable Long id) { return service.obter(id); }

    @PutMapping("/{id}")
    public Associado atualizar(@PathVariable Long id, @RequestBody Associado a) {
        a.setIdassociado(id);
        return service.salvar(a);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }

}
