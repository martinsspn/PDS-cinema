package PDSCinema.service.AdmStrategy;

import PDSCinema.model.Evento;

public abstract class AdmStrategyAbstractEvento {
    public abstract Evento buscarEvento(String nome);
    public abstract int removerEvento(Evento evento);
}
