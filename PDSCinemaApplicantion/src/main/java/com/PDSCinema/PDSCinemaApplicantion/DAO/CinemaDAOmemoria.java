package com.PDSCinema.PDSCinemaApplicantion.DAO;
import com.PDSCinema.PDSCinemaApplicantion.model.Administrador;
import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.service.iCinemaService;

import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaService {
    private Cinema cinema;

    @Override
    public void inserirCliente(Cliente cliente){
        cinema.listaClientesCpf.add(cliente.getCpf());
        cinema.listaClientes.add(cliente);

    }
    @Override
    public void removerCliente(Cliente cliente, Cinema cinema){
        cinema.listaClientesCpf.remove(cliente.getCpf());
        cinema.listaClientes.remove(cliente);
    }
    @Override
    public Cliente buscarCliente(String cpf, Cinema cinema){
        for(int i=0; i < cinema.listaClientesCpf.size(); i++){
            if (cpf == listaClientesCpf.get(i)){
                return cinema.listaClientes.get(i);
            }
        }

    }
    @Override
    public List <Cliente> buscarTodosCliente(){
        return cinema.listaClientes.get();
    }

    @Override
    public void inserirADM(Administrador ADM){
        cinema.listaAdministradorCpf.add(cliente.getCpf());
        cinema.listaAdministrador.add(cliente);
    }
    @Override
    public void removerADM(Administrador ADM, Cinema cinema){
        cinema.listaAdministradorCpf.remove(cliente.getCpf());
        cinema.listaAdministrador.remove(cliente);
    }
    @Override
    public Administrador buscarADM(String cpf, Cinema cinema){
        for(int i=0; i < cinema.listaAdministradorCpf.size(); i++){
            if (cpf == listaAdministradorCpf.get(i)){
                return cinema.listaAdministrador.get(i);
            }
        }
    }
    @Override
    public List <Administrador> buscarTodosADM(){
        return cinema.listaAdministrador.get();
    }
