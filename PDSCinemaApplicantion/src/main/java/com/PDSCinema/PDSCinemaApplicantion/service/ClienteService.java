package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Ingresso;

public class ClienteService implements iClienteService{
    private Cliente cliente;

    @Override
    public int comprarIngresso(Ingresso ingresso, float valor) {
        if(valor == ingresso.getPreco()){
            cliente.getIngressos().add(ingresso);
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public void avaliarFilme(CinemaService cinema, int avaliacao) {
        cinema.avaliarFilme(avaliacao);
    }

    @Override
    public void avaliarServico(CinemaService cinema, int avaliacao) {
        cinema.avaliarServico(avaliacao);
    }

    @Override
    public void avaliarHorario(CinemaService cinema, int avaliacao) {
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
