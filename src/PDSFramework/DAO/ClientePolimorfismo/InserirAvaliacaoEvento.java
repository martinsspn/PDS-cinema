package PDSFramework.DAO.ClientePolimorfismo;

import PDSFramework.DAO.SingletonEventoDAO;
import PDSFramework.model.Evento;

public class InserirAvaliacaoEvento {
    public void inseriAvaliacaoEvento(Evento evento, int avaliacao) {
        SingletonEventoDAO.getClienteStrategyEventoDAO().inserirAvaliacaoEvento(evento, avaliacao);
    }
}
