package com.PDSCinema.PDSCinemaApplicantion.DAO;

import com.PDSCinema.PDSCinemaApplicantion.model.*;

import java.io.IOException;
import java.util.List;

public interface CinemaDAO {
    void inserirCliente(String cpf, String nome);
    void removerCliente(Cliente cliente, Cinema cinema);
    Cliente buscarCliente(String cpf, Cinema cinema);
    List<Cliente> buscarTodosCliente();
    void inserirADM(Administrador ADM);
    void removerADM(Administrador ADM, Cinema cinema);
    Administrador buscarADM(String cpf, Cinema cinema);
    List <Administrador> buscarTodosADM();
}

