package com.PDSCinema.PDSCinemaApplicantion.DAO;
import com.PDSCinema.PDSCinemaApplicantion.model.Administrador;
import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.service.iCinemaService;

import java.util.List;

public class CinemaDAOmemoria implements CinemaDAO {
    private Cinema cinema;

    @Override
    public void inserirCliente(Cliente cliente) {
        cinema.getListaClientesCpf().add(cliente.getCpf());
        cinema.getListaClientes().add(cliente);

    }

    @Override
    public void removerCliente(Cliente cliente, Cinema cinema) {
        cinema.getListaClientesCpf().remove(cliente.getCpf());
        cinema.getListaClientes().remove(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf, Cinema cinema) {
        for (int i = 0; i < cinema.getListaClientesCpf().size(); i++) {
            if (cpf == cinema.getListaClientesCpf().get(i)) {
                return cinema.getListaClientes().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodosCliente() {
        return cinema.getListaClientes();
    }

    @Override
    public void inserirADM(Administrador ADM) {
        cinema.listaAdministradorCpf.add(cliente.getCpf());
        cinema.listaAdministrador.add(cliente);
    }

    @Override
    public void removerADM(Administrador ADM, Cinema cinema) {
        cinema.listaAdministradorCpf.remove(cliente.getCpf());
        cinema.listaAdministrador.remove(cliente);
    }

    @Override
    public Administrador buscarADM(String cpf, Cinema cinema) {
        for (int i = 0; i < cinema.listaAdministradorCpf.size(); i++) {
            if (cpf == listaAdministradorCpf.get(i)) {
                return cinema.listaAdministrador.get(i);
            }
        }
    }

    @Override
    public List<Administrador> buscarTodosADM() {
        return cinema.listaAdministrador.get();
    }
}