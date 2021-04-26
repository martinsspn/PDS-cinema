package PDSFramework.DAO.ADMStrategy;

import PDSFramework.model.Evento;

public abstract class AdmStrategyAbstractEvento {
    public abstract Evento buscarEvento(String evento);
    public abstract void removerEvento(Evento evento);
}
