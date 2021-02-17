package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

public interface iClienteService {
    void comprarIngresso();
    void avaliarFilme(Filme filme, int avaliacao);
    void avaliarServico(Cinema cinema, int avaliacao);
    void avaliarHorario(Cinema cinema, int avaliacao);
    void utilizarCupom();
    void compartilharCupom();
    void resgatarPremio();
}
