package PDSFramework.service.EventoStrategy;

import PDSFramework.model.Evento;

import java.util.ArrayList;
import java.util.List;

public abstract class EventoStrategyAbstractEvento {
    public abstract List<Double> calcularMediaAvaliacaoEvento(List<Evento> eventos);
    public abstract ArrayList<String> calcularRanking(List<Evento> listaDeEventos);
}
