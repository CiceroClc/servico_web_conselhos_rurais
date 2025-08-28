package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco_urbano")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EnderecoUrbano extends Endereco
{
	private String rua;
    private String cep;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

}
