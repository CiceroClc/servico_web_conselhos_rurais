package com.smapp.sist_conselhos_rurais.controller;

import com.smapp.sist_conselhos_rurais.models.ReuniaoSecretaria;
import com.smapp.sist_conselhos_rurais.service.ReuniaoSecretariaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reunioes/secretaria")
public class ReuniaoSecretariaController {
	
	private final ReuniaoSecretariaService service;

    public ReuniaoSecretariaController(ReuniaoSecretariaService service){
        this.service = service;
    }

    @GetMapping
    public List<ReuniaoSecretaria> listar(
            @RequestParam(required = false) String pauta,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return service.listar(pauta, data);
    }

    @GetMapping("/{id}")
    public ReuniaoSecretaria obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReuniaoSecretaria criar(@RequestBody ReuniaoSecretaria reuniao) {
        return service.salvar(reuniao);
    }

    @PutMapping("/{id}")
    public ReuniaoSecretaria atualizar(@PathVariable Long id, @RequestBody ReuniaoSecretaria reuniao) {
        reuniao.setIdreuniao(id);
        return service.salvar(reuniao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}