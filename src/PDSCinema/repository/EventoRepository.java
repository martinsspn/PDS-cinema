package PDSCinema.repository;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.model.Premio;

import java.util.HashMap;
import java.util.List;

public abstract class EventoRepository {

    protected int avaliacoesServico;
    protected int quantAvServico;
    protected List<Double> medias;
    protected HashMap<String, Cupom> listaDeCupons;
    protected HashMap<Integer, Premio> listaDePremios;

    public List<Double> getMedias() {
        return medias;
    }
    public void setMedias(List<Double> medias) {
        this.medias = medias;
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
}
