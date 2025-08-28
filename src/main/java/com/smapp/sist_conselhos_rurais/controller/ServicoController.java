package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.models.Servico;
import com.smapp.sist_conselhos_rurais.repository.ServicoRepository;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
	
	private final ServicoRepository repository;
    public ServicoController(ServicoRepository repository){this.repository=repository;}

    @GetMapping public List<Servico> listar(){return repository.findAll();}
    @PostMapping public Servico salvar(@RequestBody Servico s){return repository.save(s);}

}
