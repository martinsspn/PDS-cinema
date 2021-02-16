package com.PDSCinema.PDSCinemaApplicantion.service;

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
    public void avaliarServico(Filme filme, int avaliacao) {
        filme.avaliarServico(avaliacao);
    }

    @Override
    public void avaliarHorario(Filme filme, int avaliacao) {
        filme.avaliarHorario(avaliacao);
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
