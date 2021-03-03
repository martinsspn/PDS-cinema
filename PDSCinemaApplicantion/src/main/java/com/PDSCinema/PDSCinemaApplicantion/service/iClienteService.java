package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Ingresso;

public interface iClienteService {
    int avaliarServico(Cinema cinema, int avaliacao);
    int avaliarHorario(Cinema cinema, int avaliacao);
    int utilizarCupom();
	int compartilharCupom();
    int resgatarPremio();
	int avaliarFilme(Filme filme, int avaliacao);
	int comprarIngresso(Ingresso ingresso, int pagamento);
}
