package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.models.ReuniaoSecretaria;
import com.smapp.sist_conselhos_rurais.repository.ReuniaoSecretariaRepository;

@RestController
@RequestMapping("/reunioes/secretaria")
public class ReuniaoSecretariaController {
	
	private final ReuniaoSecretariaRepository repository;
    public ReuniaoSecretariaController(ReuniaoSecretariaRepository repository){this.repository=repository;}

    @GetMapping public List<ReuniaoSecretaria> listar(){return repository.findAll();}
    @PostMapping public ReuniaoSecretaria salvar(@RequestBody ReuniaoSecretaria r){return repository.save(r);}

}
