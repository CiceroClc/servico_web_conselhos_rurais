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
public class ReuniaoSecretariaService {

    private final ReuniaoSecretariaRepository reuniaoRepo;
    private final ConselhoRepository conselhoRepo;

    public ReuniaoSecretariaService(ReuniaoSecretariaRepository reuniaoRepo, ConselhoRepository conselhoRepo) {
        this.reuniaoRepo = reuniaoRepo;
        this.conselhoRepo = conselhoRepo;
    }

    public List<ReuniaoSecretaria> listar(String pauta, LocalDate data) {
        if (pauta != null && !pauta.trim().isEmpty()) {
            return reuniaoRepo.findByPautaContainingIgnoreCase(pauta);
        }
        if (data != null) {
            return reuniaoRepo.findByData(data);
        }
        return reuniaoRepo.findAll();
    }

    public ReuniaoSecretaria obter(Long id) {
        return reuniaoRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reunião da Secretaria não encontrada com o id: " + id));
    }

    @Transactional
    public ReuniaoSecretaria salvar(ReuniaoSecretaria reuniao) {
        if (reuniao.getIdreuniao() == null) {
            List<Conselho> todosConselhos = conselhoRepo.findAll();
            List<PresencaReuniaoSecretaria> presencas = todosConselhos.stream().map(conselho -> {
                PresencaReuniaoSecretariaId presencaId = new PresencaReuniaoSecretariaId(reuniao.getIdreuniao(), conselho.getIdconselho());
                PresencaReuniaoSecretaria presenca = new PresencaReuniaoSecretaria();
                presenca.setId(presencaId);
                presenca.setReuniao(reuniao);
                presenca.setConselho(conselho);
                presenca.setPresente(false);
                return presenca;
            }).collect(Collectors.toList());
            reuniao.setPresencas(presencas);
        }
        return reuniaoRepo.save(reuniao);
    }

    public void deletar(Long id) {
        if (!reuniaoRepo.existsById(id)) {
            throw new NoSuchElementException("Reunião da Secretaria não encontrada com o id: " + id);
        }
        reuniaoRepo.deleteById(id);
    }
}