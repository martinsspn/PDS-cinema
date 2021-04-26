package PDSFramework.repository;

import PDSFramework.model.Cupom;
import PDSFramework.model.Premio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class EventoRepository {

    protected static int avaliacoesServico = 0;
    protected static int quantAvServico = 0;
    protected static List<Double> medias = new ArrayList<>();
    protected static HashMap<String, Cupom> listaDeCupons = new HashMap<>();
    protected static HashMap<Integer, Premio> listaDePremios = new HashMap<>();

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
