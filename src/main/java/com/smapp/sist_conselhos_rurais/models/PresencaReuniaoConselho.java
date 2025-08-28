package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "presenca_reuniao_conselho")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PresencaReuniaoConselho 
{
	@EmbeddedId
    private PresencaReuniaoConselhoId id;

    @ManyToOne @MapsId("idreuniao")
    private ReuniaoConselho reuniao;

    @ManyToOne @MapsId("idassociado")
    private Associado associado;

    private Boolean presente = true;
}
