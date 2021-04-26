package PDSFramework.service.AdmStrategy;

import PDSFramework.model.Evento;

public abstract class AdmStrategyAbstractEvento {
    public abstract Evento buscarEvento(String nome);
    public abstract int removerEvento(Evento evento);
}
