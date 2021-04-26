package PDSFramework.repository;

import PDSFramework.model.Administrador;

import java.util.ArrayList;
import java.util.List;

public abstract class AdministradorRepository {
    protected static List<String> listaAdministradorCpf = new ArrayList<>();
    protected static List<Administrador> listaAdministrador = new ArrayList<>();

    public static List<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }
    public static void setListaAdministrador(List<Administrador> listaAdministrador) {
        AdministradorRepository.listaAdministrador = listaAdministrador;
    }
    public static List<String> getListaAdministradorCpf() {
        return listaAdministradorCpf;
    }
    public static void setListaAdministradorCpf(List<String> listaAdministradorCpf) {
        AdministradorRepository.listaAdministradorCpf = listaAdministradorCpf;
    }
}
