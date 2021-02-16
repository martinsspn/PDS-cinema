package com.PDSCinema.PDSCinemaApplicantion.model;

import java.util.ArrayList;

public class Ranking {
	ArrayList<Filme> filme;
	ArrayList<Ingresso> ingressos;

	public ArrayList<Filme> getFilme() {
		return filme;
	}

	public void setFilme(ArrayList<Filme> filme) {
		this.filme = filme;
	}

	public ArrayList<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(ArrayList<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
}
