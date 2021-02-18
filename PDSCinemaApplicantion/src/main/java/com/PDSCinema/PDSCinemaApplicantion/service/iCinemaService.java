package com.PDSCinema.PDSCinemaApplicantion.service;

public interface iCinemaService {
   public void inserirCliente(Cliente cliente);
    public void removerCliente(Cliente cliente);
    public void buscarCliente(Cliente cliente);
    public List <Cliente> buscarTodosCliente();
    public void inserirADM(Administrador ADM);
    public void removerADM(Administrador ADM);
    public void buscarADM(Administrador ADM);
    public List <Administrador> buscarTodosADM();
    public void calcularMediaAvaliacao();
}
