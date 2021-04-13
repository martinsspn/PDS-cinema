package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.repository.AdministradorRepository;
import PDSCinema.model.Cliente;
import PDSCinema.repository.ClienteRepository;
import PDSCinema.repository.EventoRepository;

import java.util.List;

public interface EventoDAO {
    void inserirCliente(ClienteRepository clienteRepository, String cpf, String nome);
    void removerCliente(ClienteRepository clienteRepository, Cliente cliente);
    Cliente buscarCliente(ClienteRepository clienteRepository, String cpf);
    List<Cliente> buscarTodosCliente(ClienteRepository clienteRepository);
    void inserirADM(AdministradorRepository administradorRepository, String nome, String cpf);
    void removerADM(AdministradorRepository administradorRepository, Administrador adm);
    Administrador buscarADM(AdministradorRepository administradorRepository, String cpf);
    List <Administrador> buscarTodosADM(AdministradorRepository administradorRepository);
}

