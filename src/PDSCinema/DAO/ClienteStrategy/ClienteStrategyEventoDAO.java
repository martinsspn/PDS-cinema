package PDSCinema.DAO.ClienteStrategy;

import PDSCinema.model.Evento;

public abstract class ClienteStrategyEventoDAO {
    public abstract void avaliarEvento(Evento evento, int avaliacao);
    public abstract void comprarIngressoEvento();
}
