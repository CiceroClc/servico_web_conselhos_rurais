package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gestor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Gestor 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idgestor;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf;

    @OneToOne(optional = false)
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

}
