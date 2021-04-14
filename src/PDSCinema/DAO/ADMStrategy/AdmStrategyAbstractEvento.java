package PDSCinema.DAO.ADMStrategy;

import PDSCinema.model.Evento;
import PDSCinema.model.Filme;

public abstract class AdmStrategyAbstractEvento {
    public abstract Evento buscarEvento(String evento);
    public abstract void removerEvento(Evento evento);
}
