package com.PDSCinema.PDSCinemaApplicantion.model;

import java.util.List;

public class Cinema {
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

