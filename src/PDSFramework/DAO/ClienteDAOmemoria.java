package PDSFramework.DAO;

import PDSFramework.DAO.ClientePolimorfismo.InserirAvaliacaoEvento;
import PDSFramework.DAO.ClienteStrategy.ClienteStrategyEventoDAO;
import PDSFramework.model.*;
import PDSFramework.repository.EventoRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOmemoria implements ClienteDAO{

    private ClienteStrategyEventoDAO clienteStrategyEventoDAO;

    private InserirAvaliacaoEvento inserirAvaliacaoEvento = new InserirAvaliacaoEvento();

    public ClienteDAOmemoria(ClienteStrategyEventoDAO clienteStrategyEventoDAO){
        this.clienteStrategyEventoDAO = clienteStrategyEventoDAO;
    }

    public ClienteStrategyEventoDAO getClienteStrategyEventoDAO() {
        return clienteStrategyEventoDAO;
    }

    @Override
    public int avaliarServico(int avaliacao) {
        int avaliacoes = EventoRepository.getAvaliacoesServico();
        EventoRepository.setAvaliacoesServico(avaliacoes+avaliacao);
        EventoRepository.setQuantAvServico(EventoRepository.getQuantAvServico()+1);
        return 0;
    }

    @Override
    public int resgatarCupom(Cliente cliente, String codigo)  {
        cliente.getCuponsAtivos().add(EventoRepository.getListaDeCupons().get(codigo));
        return 0;
    }

    @Override
    public String compartilharCupom(Cliente cliente) {
        String compartilhar = "Cupom: " + cliente.getCuponsUsados().get(0).getCodigo()
                + "\n" + "Valor do Cupom: R$" + cliente.getCuponsUsados().get(0).getTipoDeCupom() + "\n";
        return compartilhar;
    }

    @Override
    public Premio resgatarPremio(Cliente cliente, int codigo){
        for(Premio p: cliente.getPremios()){
            if(p.getIdPremio() == codigo){
                return p;
            }
        }
        return null;
    }

    @Override
    public void alterarCondicaoPremio(Cliente cliente, int codigo, int condicao){
        cliente.getCondicoesPremios().set(codigo, condicao);
    }

    @Override
    public int comprarIngresso(Ingresso ingresso, Cliente cliente) {
        cliente.getIngressos().add(ingresso);
        List<Integer> auxiliar = new ArrayList<>();
        for(int i=0; i<cliente.getCondicoesPremios().size(); i++){
            auxiliar.add(cliente.getCondicoesPremios().get(i)+1);
        }
        cliente.setCondicoesPremios(auxiliar);
        return 0;
    }

    @Override
    public int comprarIngresso(Ingresso ingresso, Cliente cliente, Cupom cupom) {
        cliente.getIngressos().add(ingresso);
        List<Integer> auxiliar = new ArrayList<>();
        for(int i=0; i<cliente.getCondicoesPremios().size(); i++){
            auxiliar.add(cliente.getCondicoesPremios().get(i)+1);
        }
        cliente.setCondicoesPremios(auxiliar);
        cliente.getCuponsUsados().add(cupom);
        cliente.getCuponsAtivos().remove(cupom);
        return 0;
    }

    public InserirAvaliacaoEvento getInserirAvaliacaoEvento() {
        return inserirAvaliacaoEvento;
    }
}
