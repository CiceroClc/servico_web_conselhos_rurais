package com.smapp.sist_conselhos_rurais.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conselho")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Conselho 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconselho;

    @Column(nullable = false)
    private String nome;

    private Integer nro_membros;
    private String presidente;

    @OneToMany(mappedBy = "conselho")
    private List<Associado> associados = new ArrayList<>();

}
