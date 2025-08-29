package com.smapp.sist_conselhos_rurais.controller;

import com.smapp.sist_conselhos_rurais.models.ReuniaoConselho;
import com.smapp.sist_conselhos_rurais.service.ReuniaoConselhoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reunioes/conselho")
public class ReuniaoConselhoController {

	private final ReuniaoConselhoService service;

    public ReuniaoConselhoController(ReuniaoConselhoService service){
        this.service = service;
    }

    @GetMapping
    public List<ReuniaoConselho> listar(
            @RequestParam(required = false) String pauta,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return service.listar(pauta, data);
    }

    @GetMapping("/{id}")
    public ReuniaoConselho obter(@PathVariable Long id) {
        return service.obter(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReuniaoConselho criar(@RequestBody ReuniaoConselho reuniao) {
        return service.salvar(reuniao);
    }

    @PutMapping("/{id}")
    public ReuniaoConselho atualizar(@PathVariable Long id, @RequestBody ReuniaoConselho reuniao) {
        reuniao.setIdreuniao(id);
        return service.salvar(reuniao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}