package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.smapp.sist_conselhos_rurais.models.Associado;
import com.smapp.sist_conselhos_rurais.service.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {
	
	private final AssociadoService service;

    public AssociadoController(AssociadoService s) {
        this.service = s;
    }

    @GetMapping
    public List<Associado> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        return service.listar(nome, cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Associado criar(@RequestBody Associado a) {
        return service.salvar(a);
    }

    @GetMapping("/{id}")
    public Associado obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PutMapping("/{id}")
    public Associado atualizar(@PathVariable Long id, @RequestBody Associado a) {
        a.setIdassociado(id);
        return service.salvar(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}