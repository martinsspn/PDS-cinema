package PDSCinema.repository;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.model.Premio;

import java.util.HashMap;
import java.util.List;

public abstract class EventoRepository {

    protected static int avaliacoesServico;
    protected static int quantAvServico;
    protected static List<Double> medias;
    protected static HashMap<String, Cupom> listaDeCupons;
    protected static HashMap<Integer, Premio> listaDePremios;

    public static List<Double> getMedias() {
        return medias;
    }
    public static void setMedias(List<Double> medias) {
        EventoRepository.medias = medias;
    }
    public static HashMap<String, Cupom> getListaDeCupons() {
        return listaDeCupons;
    }
    public static void setListaDeCupons(HashMap<String, Cupom> listaDeCupons) {
        EventoRepository.listaDeCupons = listaDeCupons;
    }
    public static HashMap<Integer, Premio> getListaDePremios() {
        return EventoRepository.listaDePremios;
    }
    public static void setListaDePremios(HashMap<Integer, Premio> listaDePremios) {
        EventoRepository.listaDePremios = listaDePremios;
    }
    public static int getAvaliacoesServico() {
        return avaliacoesServico;
    }
    public static void setAvaliacoesServico(int avaliacoesServico) {
        EventoRepository.avaliacoesServico = avaliacoesServico;
    }
    public static int getQuantAvServico() {
        return EventoRepository.quantAvServico;
    }
    public static void setQuantAvServico(int quantAvServico) {
        EventoRepository.quantAvServico = quantAvServico;
    }
}
