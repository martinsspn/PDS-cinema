package PDSFramework.DAO;

import PDSFramework.model.Administrador;
import PDSFramework.model.Cliente;

import java.util.List;

public interface EventoDAO {
    void inserirCliente(String cpf, String nome);
    void removerCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    List<Cliente> buscarTodosCliente();
    void inserirADM(String nome, String cpf);
    void removerADM(Administrador adm);
    Administrador buscarADM(String cpf);
    List <Administrador> buscarTodosADM();
}

