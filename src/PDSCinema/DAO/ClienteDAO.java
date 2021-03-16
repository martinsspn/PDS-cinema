package PDSCinema.DAO;

import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;

public interface ClienteDAO {
    int avaliarServico(CinemaRepository cinema, int avaliacao);
    int avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao) throws IOException;
    int utilizarCupom();
    int compartilharCupom();
    int resgatarPremio();
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso);
}
