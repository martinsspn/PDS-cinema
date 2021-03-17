package PDSCinema.model;

import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Usuario {
    private List<Ingresso> ingressos;
    private List<Cupom> cuponsUsados;
    private List<Cupom> cuponsAtivos;
    private List<Premio> premios;
    private List<Integer> condicoesPremios;

    public ClienteService clienteService;

    public Cliente() {
        this.ingressos = new ArrayList<>();
        this.cuponsUsados = new ArrayList<>();
        this.premios = new ArrayList<>();
        this.condicoesPremios = new ArrayList<>();
        this.clienteService = new ClienteService();
    }

    public void setCuponsUsados(List<Cupom> cuponsUsados) {
        this.cuponsUsados = cuponsUsados;
    }

    public List<Cupom> getCuponsAtivos() {
        return cuponsAtivos;
    }

    public void setCuponsAtivos(List<Cupom> cuponsAtivos) {
        this.cuponsAtivos = cuponsAtivos;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public List<Integer> getCondicoesPremios() {
        return condicoesPremios;
    }

    public void setCondicoesPremios(List<Integer> condicoesPremios) {
        this.condicoesPremios = condicoesPremios;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public List<Cupom> getCuponsUsados() {
        return cuponsUsados;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cuponsUsados = cupons;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }
}
