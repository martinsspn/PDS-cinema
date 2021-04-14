package PDSCinema.DAO.ClientePolimorfismo;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Evento;

public abstract class AvaliarEvento {
    public static int avaliarEvento(Evento evento, int avaliacao) {
        SingletonEventoDAO.getClienteStrategyEventoDAO().avaliarEvento(evento, avaliacao);
        return 0;
    }
}
