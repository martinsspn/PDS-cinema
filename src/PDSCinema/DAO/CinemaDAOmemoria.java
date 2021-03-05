package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;

import java.util.List;

public class CinemaDAOmemoria implements CinemaDAO {

    @Override
    public void inserirCliente(Cinema cinema, String cpf, String nome){
        cinema.getListaClientesCpf().add(cpf);
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf); cinema.getListaClientes().add(cliente);

    }

    @Override
    public void removerCliente(Cliente cliente, Cinema cinema) {
        cinema.getListaClientesCpf().remove(cliente.getCpf());
        cinema.getListaClientes().remove(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf, Cinema cinema) {
        for (int i = 0; i < cinema.getListaClientesCpf().size(); i++) {
            if (cpf.equals(cinema.getListaClientesCpf().get(i))) {
                return cinema.getListaClientes().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodosCliente(Cinema cinema) {
        return cinema.getListaClientes();
    }

    @Override
    public void inserirADM(Cinema cinema, Administrador adm) {
        cinema.getListaAdministradorCpf().add(adm.getCpf());
        cinema.getListaAdministrador().add(adm);
    }

    @Override
    public void removerADM(Administrador adm, Cinema cinema) {
        cinema.getListaAdministradorCpf().remove(adm.getCpf());
        cinema.getListaAdministrador().remove(adm);
    }

    @Override
    public Administrador buscarADM(String cpf, Cinema cinema) {
        for (int i = 0; i < cinema.getListaAdministradorCpf().size(); i++) {
            if (cpf.equals(cinema.getListaAdministradorCpf().get(i))) {
                return cinema.getListaAdministrador().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Administrador> buscarTodosADM(Cinema cinema) {
        return cinema.getListaAdministrador();
    }
}