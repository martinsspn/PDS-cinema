package PDSCinema.repository;

import PDSCinema.model.Administrador;

import java.util.List;

public class AdministradorRepository {
    protected List<String> listaAdministradorCpf;
    protected List<Administrador> listaAdministrador;

    public List<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }
    public void setListaAdministrador(List<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }
    public List<String> getListaAdministradorCpf() {
        return listaAdministradorCpf;
    }
    public void setListaAdministradorCpf(List<String> listaAdministradorCpf) {
        this.listaAdministradorCpf = listaAdministradorCpf;
    }
}
