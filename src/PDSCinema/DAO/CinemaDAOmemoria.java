package PDSCinema.DAO;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

public class CinemaDAOmemoria implements CinemaDAO {

    private List<Integer> salas;
    private List<String> listaClientesCpf;
    private List<Cliente> listaClientes;
    private List<String> listaAdministradorCpf;
    private List<Administrador> listaAdministrador;
    private List<Filme> filmesEmCartaz;
    private List<String> horarios;
    private int avaliacoesServico;
    private List<Integer> avaliacoesHorarios;
    private int quantAvServico;
    private List<Integer> quantAvHorarios;

    public CinemaDAOmemoria() {
        this.salas = new ArrayList<>();
        this.listaClientesCpf = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaAdministradorCpf = new ArrayList<>();
        this.listaAdministrador = new ArrayList<>();
        this.filmesEmCartaz = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.avaliacoesServico = 0;
        this.avaliacoesHorarios = new ArrayList<>();
        this.quantAvServico = 0;
        this.quantAvHorarios = new ArrayList<>();
    }

    @Override
    public void inserirCliente(String cpf, String nome){
        listaClientesCpf.add(cpf);
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        listaClientes.add(cliente);
    }

    @Override
    public void removerCliente(Cliente cliente) {
        listaClientesCpf.remove(cliente.getCpf());
        listaClientes.remove(cliente);
    }

    @Override
    public Cliente buscarCliente(String cpf) {
        for (int i = 0; i < listaClientesCpf.size(); i++) {
            if (cpf.equals(listaClientesCpf.get(i))) {
                return listaClientes.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodosCliente() {
        return listaClientes;
    }

    @Override
    public void inserirADM(String cpf, String nome) {
        listaAdministradorCpf.add(cpf);
        Administrador administrador = new Administrador();
        administrador.setNome(nome);
        administrador.setCpf(cpf); listaAdministrador.add(administrador);
    }

    @Override
    public void removerADM(Administrador adm) {
        listaAdministradorCpf.remove(adm.getCpf());
        listaAdministrador.remove(adm);
    }

    @Override
    public Administrador buscarADM(String cpf) {
        for (int i = 0; i < listaAdministradorCpf.size(); i++) {
            if (cpf.equals(listaAdministradorCpf.get(i))) {
                return listaAdministrador.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Administrador> buscarTodosADM() {
        return listaAdministrador;
    }
}