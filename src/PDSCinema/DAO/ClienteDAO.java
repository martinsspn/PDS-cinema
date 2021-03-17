package PDSCinema.DAO;

import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;

public interface ClienteDAO {
    int avaliarServico(CinemaRepository cinema, int avaliacao);
    int avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao) throws IOException;
    int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo);
    int compartilharCupom();
    int resgatarPremio(CinemaRepository cinema, Cliente cliente, String codigo);
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso);
}
