package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.models.ReuniaoConselho;
import com.smapp.sist_conselhos_rurais.repository.ReuniaoConselhoRepository;

@RestController
@RequestMapping("/reunioes/conselho")
public class ReuniaoConselhoController {

	private final ReuniaoConselhoRepository repository;
    public ReuniaoConselhoController(ReuniaoConselhoRepository repository){this.repository=repository;}

    @GetMapping public List<ReuniaoConselho> listar(){return repository.findAll();}
    @PostMapping public ReuniaoConselho salvar(@RequestBody ReuniaoConselho r){return repository.save(r);}
	
}
