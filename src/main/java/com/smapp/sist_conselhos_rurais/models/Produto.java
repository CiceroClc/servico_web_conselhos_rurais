package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Produto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproduto;
	
	@Column(nullable = false)
	private String nome;
	
	private String descricao;

}
