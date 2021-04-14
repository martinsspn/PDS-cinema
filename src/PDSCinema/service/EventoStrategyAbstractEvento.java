package PDSCinema.service;

import PDSCinema.model.Evento;
import PDSCinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

public abstract class EventoStrategyAbstractEvento {
    public abstract void calcularMediaAv();
    public abstract ArrayList<String> calcularRanking(List<Evento> listaDeEventos);
}
