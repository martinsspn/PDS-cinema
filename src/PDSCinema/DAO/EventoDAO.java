package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.model.Cliente;

import java.util.List;

public interface EventoDAO {
    void inserirCliente(CinemaRepository cinema, String cpf, String nome);
    void removerCliente(CinemaRepository cinema, Cliente cliente);
    Cliente buscarCliente(CinemaRepository cinema, String cpf);
    List<Cliente> buscarTodosCliente(CinemaRepository cinema);
    void inserirADM(CinemaRepository cinema, String nome, String cpf);
    void removerADM(CinemaRepository cinema, Administrador ADM);
    Administrador buscarADM(CinemaRepository cinema, String cpf);
    List <Administrador> buscarTodosADM(CinemaRepository cinema);
}

