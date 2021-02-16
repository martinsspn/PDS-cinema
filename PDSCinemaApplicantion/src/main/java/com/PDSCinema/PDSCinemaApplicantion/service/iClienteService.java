package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

public interface iClienteService {
    void comprarIngresso();
    void avaliarFilme(Filme filme, int avaliacao);
    void avaliarServico(Filme filme, int avaliacao);
    void avaliarHorario(Filme filme, int avaliacao);
    void utilizarCupom();
    void compartilharCupom();
    void resgatarPremio();
}
