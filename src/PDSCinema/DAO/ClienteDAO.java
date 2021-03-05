package PDSCinema.DAO;


import PDSCinema.model.Cinema;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;

import java.io.IOException;

public interface ClienteDAO {
    int avaliarServico(Cinema cinema, int avaliacao);
    int avaliarHorario(Cinema cinema, String horario ,int avaliacao) throws IOException;
    int utilizarCupom();
    int compartilharCupom();
    int resgatarPremio();
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso);
}
