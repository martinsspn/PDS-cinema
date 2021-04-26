package PDSFramework.DAO.ClienteStrategy;

import PDSFramework.model.Evento;

import java.io.IOException;

public class ClienteCirco extends ClienteStrategyEventoDAO{
    @Override
    public void inserirAvaliacaoEvento(Evento evento, int avaliacao){

    }

    @Override
    public int inserirAvaliacaoHorario(String horario, int avaliacao) throws IOException {
        return 0;
    }
}
