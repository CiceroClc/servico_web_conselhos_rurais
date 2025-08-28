package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco_rural")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EnderecoRural extends Endereco
{
	private String comunidade;
    @Column(columnDefinition = "TEXT")
    private String descricao;

}
