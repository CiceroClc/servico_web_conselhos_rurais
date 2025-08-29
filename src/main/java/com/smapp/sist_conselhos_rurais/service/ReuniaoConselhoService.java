package com.smapp.sist_conselhos_rurais.service;

import com.smapp.sist_conselhos_rurais.models.*;
import com.smapp.sist_conselhos_rurais.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReuniaoConselhoService {

    private final ReuniaoConselhoRepository reuniaoRepo;
    private final AssociadoRepository associadoRepo;

    public ReuniaoConselhoService(ReuniaoConselhoRepository reuniaoRepo, AssociadoRepository associadoRepo) {
        this.reuniaoRepo = reuniaoRepo;
        this.associadoRepo = associadoRepo;
    }

    public List<ReuniaoConselho> listar(String pauta, LocalDate data) {
        if (pauta != null && !pauta.trim().isEmpty()) {
            return reuniaoRepo.findByPautaContainingIgnoreCase(pauta);
        }
        if (data != null) {
            return reuniaoRepo.findByData(data);
        }
        return reuniaoRepo.findAll();
    }

    public ReuniaoConselho obter(Long id) {
        return reuniaoRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reunião de Conselho não encontrada com o id: " + id));
    }

    @Transactional
    public ReuniaoConselho salvar(ReuniaoConselho reuniao) {
        if (reuniao.getIdreuniao() == null) {
            Conselho conselho = reuniao.getConselho();
            List<Associado> associadosDoConselho = associadoRepo.findAll().stream()
                .filter(a -> a.getConselho().getIdconselho().equals(conselho.getIdconselho()))
                .collect(Collectors.toList());

            List<PresencaReuniaoConselho> presencas = associadosDoConselho.stream().map(associado -> {
                PresencaReuniaoConselhoId presencaId = new PresencaReuniaoConselhoId(reuniao.getIdreuniao(), associado.getIdassociado());
                PresencaReuniaoConselho presenca = new PresencaReuniaoConselho();
                presenca.setId(presencaId);
                presenca.setReuniao(reuniao);
                presenca.setAssociado(associado);
                presenca.setPresente(false); // Inicia como ausente
                return presenca;
            }).collect(Collectors.toList());
            reuniao.setPresencas(presencas);
        }
        return reuniaoRepo.save(reuniao);
    }
    
    public void deletar(Long id) {
        if (!reuniaoRepo.existsById(id)) {
            throw new NoSuchElementException("Reunião de Conselho não encontrada com o id: " + id);
        }
        reuniaoRepo.deleteById(id);
    }
}