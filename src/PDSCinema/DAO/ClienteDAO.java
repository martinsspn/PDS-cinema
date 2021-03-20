package PDSCinema.DAO;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;

public interface ClienteDAO {
    int avaliarServico(CinemaRepository cinema, int avaliacao);
    int avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao) throws IOException;
    int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo);
    int compartilharCupom();
    void alterarCondicaoPremio(Cliente cliente, int codigo, int condicao);
    Premio resgatarPremio(CinemaRepository cinema, Cliente cliente, int codigo);
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso);
}
