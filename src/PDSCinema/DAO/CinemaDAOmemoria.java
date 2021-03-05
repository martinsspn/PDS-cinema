package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.service.ClienteService;

import java.util.List;

public class CinemaDAOmemoria implements CinemaDAO {

    @Override
    public void inserirCliente(Cinema cinema, String cpf, String nome){
        cinema.getListaClientesCpf().add(cpf);
        ClienteService cliente = new ClienteService();
        cliente.getCliente().setNome(nome);
        cliente.getCliente().setCpf(cpf); cinema.getListaClientes().add(cliente);

    }

    @Override
    public void removerCliente(Cliente cliente, Cinema cinema) {
        cinema.getListaClientesCpf().remove(cliente.getCpf());
        cinema.getListaClientes().remove(cliente);
    }

    @Override
    public ClienteService buscarCliente(String cpf, Cinema cinema) {
        for (int i = 0; i < cinema.getListaClientesCpf().size(); i++) {
            if (cpf.equals(cinema.getListaClientesCpf().get(i))) {
                return cinema.getListaClientes().get(i);
            }
        }
        return null;
    }

    @Override
    public List<ClienteService> buscarTodosCliente(Cinema cinema) {
        return cinema.getListaClientes();
    }

    @Override
    public void inserirADM(Cinema cinema, String cpf, String nome) {
        cinema.getListaAdministradorCpf().add(cpf);
        Administrador administrador = new Administrador();
        administrador.setNome(nome);
        administrador.setCpf(cpf); cinema.getListaAdministrador().add(administrador);
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