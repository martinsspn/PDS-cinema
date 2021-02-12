package com.PDSCinema.PDSCinemaApplicantion.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Premio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idPremio;

	String descricao;

	public int getIdPremio() {
		return idPremio;
	}

	public void setIdPremio(int idPremio) {
		this.idPremio = idPremio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
