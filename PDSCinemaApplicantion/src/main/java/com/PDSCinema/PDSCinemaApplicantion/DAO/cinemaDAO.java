package com.PDSCinema.PDSCinemaApplicantion.DAO;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Ingresso;

import java.io.IOException;

public interface CinemaDAO {
    void inserirCliente(Cliente cliente);
    void removerCliente(Cliente cliente, Cinema cinema);
    Cliente buscarCliente(String cpf, Cinema cinema);
    List <Cliente> buscarTodosCliente();
    void inserirADM(Administrador ADM);
    void removerADM(Administrador ADM, Cinema cinema);
    Administrador buscarADM(String cpf, Cinema cinema);
    List <Administrador> buscarTodosADM();
}

