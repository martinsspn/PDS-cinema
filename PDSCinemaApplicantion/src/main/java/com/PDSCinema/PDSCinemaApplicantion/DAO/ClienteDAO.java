package com.PDSCinema.PDSCinemaApplicantion.DAO;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Ingresso;

import java.io.IOException;

public interface ClienteDAO {
    int avaliarServico(Cinema cinema, int avaliacao);
    int avaliarHorario(Cinema cinema, String horario ,int avaliacao) throws IOException;
    int utilizarCupom();
    int compartilharCupom();
    int resgatarPremio();
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso);
}
