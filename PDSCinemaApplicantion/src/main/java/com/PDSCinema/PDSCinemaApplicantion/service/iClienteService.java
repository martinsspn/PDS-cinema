package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Ingresso;

import java.util.ArrayList;
import java.util.List;

public interface iClienteService {
    int avaliarServico(Cinema cinema, int avaliacao);
    int avaliarHorario(Cinema cinema, String horario ,int avaliacao);
    int utilizarCupom();
	int compartilharCupom();
    int resgatarPremio();
	int avaliarFilme(Filme filme, int avaliacao);
	int comprarIngresso(Ingresso ingresso, int pagamento);
}
