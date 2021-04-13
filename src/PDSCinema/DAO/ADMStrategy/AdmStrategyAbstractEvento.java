package PDSCinema.DAO.ADMStrategy;

import PDSCinema.model.Evento;

public abstract class AdmStrategyAbstractEvento {
    public abstract void cadastrarEvento();
    public abstract void buscarEvento();
    public abstract void removerEvento(Evento evento);
}
