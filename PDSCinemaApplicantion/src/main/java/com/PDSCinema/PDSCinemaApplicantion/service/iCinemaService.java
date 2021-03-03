package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Administrador;
import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

import java.util.List;

public interface iCinemaService {
    int inserirCliente(Cliente cliente);
    int removerCliente(Cliente cliente, Cinema cinema);
    Cliente buscarCliente(String cpf, Cinema cinema);
    List <Cliente> buscarTodosCliente();
    int inserirADM(Administrador ADM);
    int removerADM(Administrador ADM, Cinema cinema);
    Administrador buscarADM(String cpf, Cinema cinema);
    List <Administrador> buscarTodosADM();
    Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico);
    List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz);
    List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
}
