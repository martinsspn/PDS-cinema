package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.service.ClienteService;

import java.util.List;

public interface CinemaDAO {
    void inserirCliente(Cinema cinema, String cpf, String nome);
    void removerCliente(Cliente cliente, Cinema cinema);
    ClienteService buscarCliente(String cpf, Cinema cinema);
    List<ClienteService> buscarTodosCliente(Cinema cinema);
    void inserirADM(Cinema cinema, String cpf, String nome);
    void removerADM(Administrador ADM, Cinema cinema);
    Administrador buscarADM(String cpf, Cinema cinema);
    List <Administrador> buscarTodosADM(Cinema cinema);
}

