package PDSCinema.repository;

import PDSCinema.model.Cliente;

import java.util.List;

public class ClienteRepository {
    protected List<String> listaClientesCpf;
    protected List<Cliente> listaClientes;

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public List<String> getListaClientesCpf() {
        return listaClientesCpf;
    }
    public void setListaClientesCpf(List<String> listaClientesCpf) {
        this.listaClientesCpf = listaClientesCpf;
    }
}
