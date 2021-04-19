package PDSCinema.DAO.ClienteStrategy;

import PDSCinema.model.Evento;
import PDSCinema.model.Filme;

import java.io.IOException;

public abstract class ClienteStrategyEventoDAO {
    public abstract void inserirAvaliacaoEvento(Evento evento, int avaliacao);

    public abstract int inserirAvaliacaoHorario(String horario, int avaliacao) throws IOException;
}
