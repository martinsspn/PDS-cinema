package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.repository.AdministradorRepository;
import PDSCinema.repository.ClienteRepository;
import PDSCinema.repository.EventoRepository;

import java.util.List;

public class EventoDAOmemoria implements EventoDAO {

    @Override
    public void inserirCliente(ClienteRepository clienteRepository, String cpf, String nome){
        Cupom cupom = new Cupom();
        cupom.setCodigo(nome+cpf);
        cupom.setTipoDeCupom(10.00);
        clienteRepository.getListaClientesCpf().add(cpf);
        Cliente cliente = new Cliente();
        cliente.getCuponsUsados().add(cupom);
        for(int id : EventoRepository.getListaDePremios().keySet()){
            cliente.getPremios().add(EventoRepository.getListaDePremios().get(id));
            cliente.getCondicoesPremios().add(0);
        }
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        clienteRepository.getListaClientes().add(cliente);
    }

    @Override
    public void removerCliente(ClienteRepository clienteRepository, Cliente cliente) {
        clienteRepository.getListaClientesCpf().remove(cliente.getCpf());
        clienteRepository.getListaClientes().remove(cliente);
    }

    @Override
    public Cliente buscarCliente(ClienteRepository clienteRepository, String cpf) {
        for (int i = 0; i < clienteRepository.getListaClientesCpf().size(); i++) {
            if (cpf.equals(clienteRepository.getListaClientesCpf().get(i))) {
                return clienteRepository.getListaClientes().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodosCliente(ClienteRepository clienteRepository) {
        return clienteRepository.getListaClientes();
    }

    @Override
    public void inserirADM(AdministradorRepository administradorRepository, String nome, String cpf) {
        administradorRepository.getListaAdministradorCpf().add(cpf);
        Administrador administrador = new Administrador();
        administrador.setNome(nome);
        administrador.setCpf(cpf);
        administradorRepository.getListaAdministrador().add(administrador);
    }

    @Override
    public void removerADM(AdministradorRepository administradorRepository, Administrador adm) {
        administradorRepository.getListaAdministradorCpf().remove(adm.getCpf());
        administradorRepository.getListaAdministrador().remove(adm);
    }

    @Override
    public Administrador buscarADM(AdministradorRepository administradorRepository, String cpf) {
        for (int i = 0; i < administradorRepository.getListaAdministradorCpf().size(); i++) {
            if (cpf.equals(administradorRepository.getListaAdministradorCpf().get(i))) {
                return administradorRepository.getListaAdministrador().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Administrador> buscarTodosADM(AdministradorRepository administradorRepository) {
        return administradorRepository.getListaAdministrador();
    }
}