package PDSCinema.DAO.ClienteStrategy;

import PDSCinema.model.Evento;
import PDSCinema.model.Filme;

public abstract class ClienteStrategyEventoDAO {
    public abstract void avaliarEvento(Evento evento, int avaliacao);

}
