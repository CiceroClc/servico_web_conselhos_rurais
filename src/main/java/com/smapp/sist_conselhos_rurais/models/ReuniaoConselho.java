package com.smapp.sist_conselhos_rurais.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reuniao_conselho")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReuniaoConselho 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreuniao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idconselho")
    private Conselho conselho;

    @Column(name = "data")
    private LocalDate data;

    @Column(columnDefinition = "TEXT")
    private String pauta;

    @OneToMany(mappedBy = "reuniao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresencaReuniaoConselho> presencas = new ArrayList<>();
}
