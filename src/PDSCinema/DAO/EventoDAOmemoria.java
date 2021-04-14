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
    public void inserirCliente(String cpf, String nome){
        Cupom cupom = new Cupom();
        cupom.setCodigo(nome+cpf);
        cupom.setTipoDeCupom(10.00);
        ClienteRepository.getListaClientesCpf().add(cpf);
        Cliente cliente = new Cliente();
        cliente.getCuponsUsados().add(cupom);
        for(int id : EventoRepository.getListaDePremios().keySet()){
            cliente.getPremios().add(EventoRepository.getListaDePremios().get(id));
            cliente.getCondicoesPremios().add(0);
        }
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        ClienteRepository.getListaClientes().add(cliente);
    }

    @Override
    public void removerCliente(Cliente cliente) {
        ClienteRepository.getListaClientesCpf().remove(cliente.getCpf());
        ClienteRepository.getListaClientes().remove(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        for (int i = 0; i < ClienteRepository.getListaClientesCpf().size(); i++) {
            if (cpf.equals(ClienteRepository.getListaClientesCpf().get(i))) {
                return ClienteRepository.getListaClientes().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodosCliente() {
        return ClienteRepository.getListaClientes();
    }

    @Override
    public void inserirADM(String nome, String cpf) {
        AdministradorRepository.getListaAdministradorCpf().add(cpf);
        Administrador administrador = new Administrador();
        administrador.setNome(nome);
        administrador.setCpf(cpf);
        AdministradorRepository.getListaAdministrador().add(administrador);
    }

    @Override
    public void removerADM(Administrador adm) {
        AdministradorRepository.getListaAdministradorCpf().remove(adm.getCpf());
        AdministradorRepository.getListaAdministrador().remove(adm);
    }

    @Override
    public Administrador buscarADM(String cpf) {
        for (int i = 0; i < AdministradorRepository.getListaAdministradorCpf().size(); i++) {
            if (cpf.equals(AdministradorRepository.getListaAdministradorCpf().get(i))) {
                return AdministradorRepository.getListaAdministrador().get(i);
            }
        }
        return null;
    }

    @Override
    public List<Administrador> buscarTodosADM() {
        return AdministradorRepository.getListaAdministrador();
    }
}