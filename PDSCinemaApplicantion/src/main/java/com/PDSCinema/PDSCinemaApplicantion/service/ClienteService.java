package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

public class ClienteService implements iClienteService{
    @Override
    public void comprarIngresso() {
    }

    @Override
    public void avaliarFilme(Filme filme, int avaliacao) {
        filme.avaliarFilme(avaliacao);
    }

    @Override
    public void avaliarServico(Cinema cinema, int avaliacao) {
        cinema.avaliarServico(avaliacao);
    }

    @Override
    public void avaliarHorario(Cinema cinema, int avaliacao) {
        cinema.avaliarHorario(avaliacao);
    }

    @Override
    public void utilizarCupom() {

    }

    @Override
    public void compartilharCupom() {

    }

    @Override
    public void resgatarPremio() {

    }
}
