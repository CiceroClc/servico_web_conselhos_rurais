package com.smapp.sist_conselhos_rurais.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "associado")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Associado 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idassociado;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    private String cdc;
    private Boolean presidente_conselho = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idconselho")
    private Conselho conselho;

    @OneToMany(mappedBy = "associado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "associado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="idusuario", unique = true)
    private Usuario usuario; // opcional
}
