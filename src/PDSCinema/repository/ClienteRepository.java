package PDSCinema.repository;

import PDSCinema.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    protected static List<String> listaClientesCpf = new ArrayList<>();
    protected static List<Cliente> listaClientes = new ArrayList<>();

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public static List<String> getListaClientesCpf() {
        return listaClientesCpf;
    }
}
