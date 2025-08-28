package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.models.Conselho;
import com.smapp.sist_conselhos_rurais.repository.ConselhoRepository;

@RestController
@RequestMapping("/conselhos")
public class ConselhoController {
	
	private final ConselhoRepository repo;
    public ConselhoController(ConselhoRepository repo) { this.repo = repo; }

    @GetMapping public List<Conselho> listar(){ return repo.findAll(); }
    @PostMapping public Conselho criar(@RequestBody Conselho c){ return repo.save(c); }

}
