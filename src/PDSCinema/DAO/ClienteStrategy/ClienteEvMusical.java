package PDSCinema.DAO.ClienteStrategy;

import PDSCinema.model.Evento;

import java.io.IOException;

public class ClienteEvMusical extends ClienteStrategyEventoDAO{
    @Override
    public void inserirAvaliacaoEvento(Evento evento, int avaliacao){

    }

    @Override
    public int inserirAvaliacaoHorario(String horario, int avaliacao) throws IOException {
        return 0;
    }

}
