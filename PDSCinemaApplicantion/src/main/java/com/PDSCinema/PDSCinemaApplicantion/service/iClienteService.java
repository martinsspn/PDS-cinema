package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

public interface iClienteService {
    void comprarIngresso();
    void avaliarFilme(CinemaService cinema, int avaliacao);
    void avaliarServico(CinemaService cinema, int avaliacao);
    void avaliarHorario(CinemaService cinema, int avaliacao);
    void utilizarCupom();
    void compartilharCupom();
    void resgatarPremio();
}
