package com.smapp.sist_conselhos_rurais.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PresencaReuniaoSecretariaId implements java.io.Serializable
{
	private Long idreuniao;
    private Long idconselho;
}
