package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipamento")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Equipamento 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idequipamento;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idconselho")
    private Conselho conselho;
}
