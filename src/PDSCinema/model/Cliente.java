package PDSCinema.model;

import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Usuario {
    private List<Ingresso> ingressos;
    private List<Cupom> cupons;
    private List<Premio> premios;

    public ClienteService clienteService;

    public Cliente() {
        this.ingressos = new ArrayList<>();
        this.cupons = new ArrayList<>();
        this.premios = new ArrayList<>();
        this.clienteService = new ClienteService();
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public List<Cupom> getCupons() {
        return cupons;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cupons = cupons;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }
}
