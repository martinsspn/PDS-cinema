package PDSCinema.DAO;

import PDSCinema.DAO.ClientePolimorfismo.InserirAvaliacaoEvento;
import PDSCinema.DAO.ClienteStrategy.ClienteStrategyEventoDAO;
import PDSCinema.model.*;

public interface ClienteDAO {
    ClienteStrategyEventoDAO getClienteStrategyEventoDAO();
    int avaliarServico(int avaliacao);
    int resgatarCupom(Cliente cliente, String codigo);
    void alterarCondicaoPremio(Cliente cliente, int codigo, int condicao);
    String compartilharCupom(Cliente cliente);
    Premio resgatarPremio(Cliente cliente, int codigo);
    int comprarIngresso(Ingresso ingresso, Cliente cliente);
    int comprarIngresso(Ingresso ingresso, Cliente cliente, Cupom cupom);
    InserirAvaliacaoEvento getInserirAvaliacaoEvento();
}
