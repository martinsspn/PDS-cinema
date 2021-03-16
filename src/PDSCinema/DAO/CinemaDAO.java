package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.service.ClienteService;

import java.util.List;

public interface CinemaDAO {
    void inserirCliente(String cpf, String nome);
    void removerCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    List<Cliente> buscarTodosCliente();
    void inserirADM(String cpf, String nome);
    void removerADM(Administrador ADM);
    Administrador buscarADM(String cpf);
    List <Administrador> buscarTodosADM();
}

