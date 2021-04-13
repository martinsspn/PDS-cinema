package PDSCinema.DAO;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;

public interface ClienteDAO {
    int avaliarServico(int avaliacao);
    int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo);
    void alterarCondicaoPremio(Cliente cliente, int codigo, int condicao);
    String compartilharCupom(Cliente cliente);
    Premio resgatarPremio(CinemaRepository cinema, Cliente cliente, int codigo);
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso, Cliente cliente);
    int comprarIngresso(Ingresso ingresso, Cliente cliente, Cupom cupom);
}
