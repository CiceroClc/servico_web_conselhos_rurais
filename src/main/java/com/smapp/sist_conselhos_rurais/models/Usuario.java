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
@Table(name = "usuario")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senhaHash; // BCrypt

    @ManyToOne(optional = false)
    @JoinColumn(name = "idperfil")
    private Perfil perfil;

}
