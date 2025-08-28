package com.smapp.sist_conselhos_rurais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smapp.sist_conselhos_rurais.models.Equipamento;
import com.smapp.sist_conselhos_rurais.repository.EquipamentoRepository;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	private final EquipamentoRepository repository;
    public EquipamentoController(EquipamentoRepository repository){this.repository=repository;}

    @GetMapping public List<Equipamento> listar(){return repository.findAll();}
    @PostMapping public Equipamento salvar(@RequestBody Equipamento e){return repository.save(e);}
}
