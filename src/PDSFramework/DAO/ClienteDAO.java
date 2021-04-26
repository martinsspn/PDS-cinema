package PDSFramework.DAO;

import PDSFramework.DAO.ClientePolimorfismo.InserirAvaliacaoEvento;
import PDSFramework.DAO.ClienteStrategy.ClienteStrategyEventoDAO;
import PDSFramework.model.*;

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
