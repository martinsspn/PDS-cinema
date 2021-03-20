package PDSCinema.repository;

import PDSCinema.model.*;
import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CinemaRepository {
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
    private HashMap<String, Cupom> listaDeCupons;
    private HashMap<Integer, Premio> listaDePremios;

    public CinemaRepository() {
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
        this.listaDeCupons = new HashMap<>();
        this.listaDePremios = new HashMap<>();
        horarios.add("12h30min");
        horarios.add("13h00min");
        horarios.add("13h30min");
        horarios.add("14h00min");
        horarios.add("14h30min");
        horarios.add("15h30min");
        horarios.add("17h00min");
        horarios.add("18h30min");
        horarios.add("20h00min");
        for(int i=0;i<10;i++){
            avaliacoesHorarios.add(0);
            quantAvHorarios.add(0);
        }

    }

    public HashMap<String, Cupom> getListaDeCupons() {
        return listaDeCupons;
    }

    public void setListaDeCupons(HashMap<String, Cupom> listaDeCupons) {
        this.listaDeCupons = listaDeCupons;
    }

    public HashMap<Integer, Premio> getListaDePremios() {
        return listaDePremios;
    }

    public void setListaDePremios(HashMap<Integer, Premio> listaDePremios) {
        this.listaDePremios = listaDePremios;
    }

    public List<Integer> getSalas() {
        return salas;
    }

    public void setSalas(List<Integer> salas) {
        this.salas = salas;
    }

    public List<String> getListaAdministradorCpf() {
        return listaAdministradorCpf;
    }

    public void setListaAdministradorCpf(List<String> ListaAdministradorCpf) {
        this.listaAdministradorCpf = listaAdministradorCpf;
    }

    public List<String> getListaClientesCpf() {
        return listaClientesCpf;
    }

    public void setListaClientesCpf(List<String> listaClientesCpf) {
        this.listaClientesCpf = listaClientesCpf;
    }

    public List<Filme> getFilmesEmCartaz() {
        return filmesEmCartaz;
    }

    public void setFilmesEmCartaz(List<Filme> filmesEmCartaz) {
        this.filmesEmCartaz = filmesEmCartaz;
    }

    public int getAvaliacoesServico() {
        return avaliacoesServico;
    }

    public void setAvaliacoesServico(int avaliacoesServico) {
        this.avaliacoesServico = avaliacoesServico;
    }

    public int getQuantAvServico() {
        return quantAvServico;
    }

    public void setQuantAvServico(int quantAvServico) {
        this.quantAvServico = quantAvServico;
    }

    public List<Integer> getAvaliacoesHorarios() {
        return avaliacoesHorarios;
    }

    public void setAvaliacoesHorarios(List<Integer> avaliacoesHorarios) {
        this.avaliacoesHorarios = avaliacoesHorarios;
    }
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }

    public void setListaAdministrador(List<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }
    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public List<Integer> getQuantAvHorarios() {
        return quantAvHorarios;
    }

    public void setQuantAvHorarios(List<Integer> quantAvHorarios) {
        this.quantAvHorarios = quantAvHorarios;
    }
}

