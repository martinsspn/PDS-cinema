package PDSCinema.DAO.ClientePolimorfismo;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Evento;

public class InserirAvaliacaoEvento {
    public void inseriAvaliacaoEvento(Evento evento, int avaliacao) {
        SingletonEventoDAO.getClienteStrategyEventoDAO().inserirAvaliacaoEvento(evento, avaliacao);
    }
}
