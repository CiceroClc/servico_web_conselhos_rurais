package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.smapp.sist_conselhos_rurais.models.Conselho;
import com.smapp.sist_conselhos_rurais.service.ConselhoService;

@RestController
@RequestMapping("/conselhos")
public class ConselhoController {
	
	private final ConselhoService service;

    public ConselhoController(ConselhoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Conselho> listar(@RequestParam(required = false) String nome) {
        return service.listar(nome);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conselho criar(@RequestBody Conselho c) {
        return service.salvar(c);
    }

    @GetMapping("/{id}")
    public Conselho obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PutMapping("/{id}")
    public Conselho atualizar(@PathVariable Long id, @RequestBody Conselho c) {
        c.setIdconselho(id);
        return service.salvar(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}