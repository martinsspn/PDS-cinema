package com.PDSCinema.PDSCinemaApplicantion.service;

public interface iCinemaService {
    void inserirCliente(Cliente cliente);
    void removerCliente(Cliente cliente);
    void buscarCliente(Cliente cliente);
    List <Cliente> buscarTodosCliente();
    void inserirADM(Administrador ADM);
    void removerADM(Administrador ADM);
    void buscarADM(Administrador ADM);
    List <Administrador> buscarTodosADM();
    void calcularMediaAvaliacao();
}
