package PDSCinema.DAO;

import PDSCinema.DAO.ADMStrategy.AdmStrategyAbstractEvento;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.repository.CircoRepository;
import PDSCinema.repository.ClienteRepository;
import PDSCinema.repository.EventoRepository;

import java.util.ArrayList;

public class AdministradorDAOmemoria implements AdministradorDAO{
    private AdmStrategyAbstractEvento admStrategyAbstractEvento;

    AdministradorDAOmemoria(AdmStrategyAbstractEvento admStrategyAbstractEvento){
        this.admStrategyAbstractEvento = admStrategyAbstractEvento;
    }

    public void cadastrarEvento(CircoRepository c){}
    public void cadastrarEvento(EventoRepository e){}


    @Override
    public void cadastrarCupons(String _Cupom, double tipoDeCupom){
        Cupom cupom = new Cupom();
        cupom.setTipoDeCupom(tipoDeCupom);
        cupom.setCodigo(_Cupom);
        EventoRepository.getListaDeCupons().put(_Cupom, cupom);
    }

    @Override
    public void cadastrarPremios(String descricao, int id, int condicao){
        Premio premio = new Premio();
        premio.setDescricao(descricao);
        premio.setIdPremio(id);
        premio.setCondicao(condicao);
        EventoRepository.getListaDePremios().put(premio.getIdPremio(), premio);
        for(Cliente cliente : ClienteRepository.getListaClientes()){
            cliente.getPremios().add(premio);
            cliente.getCondicoesPremios().add(0);
        }
    }

    @Override
    public Evento buscarEvento(String nome){
        return admStrategyAbstractEvento.buscarEvento(nome);
    }

    @Override
    public Cupom buscarCupons(String codigo){
        return EventoRepository.getListaDeCupons().get(codigo);
    }

    @Override
    public Premio buscarPremio(int codigo){
        return EventoRepository.getListaDePremios().get(codigo);
    }

    @Override
    public int removerEvento(Evento evento){
        admStrategyAbstractEvento.removerEvento(evento);
        return 0;
    }

    @Override
    public int removerCupons(Cupom cupom){
        EventoRepository.getListaDeCupons().remove(cupom.getCodigo());
        for(Cliente c: ClienteRepository.getListaClientes()){
            if(c.getCuponsAtivos().contains(cupom))
                c.getCuponsAtivos().remove(cupom);
        }
        return 1;
    }

    @Override
    public int removerPremios(Premio premio){
        EventoRepository.getListaDePremios().remove(premio.getIdPremio());
        for(Cliente c: ClienteRepository.getListaClientes()){
            if(c.getPremios().contains(premio))
                c.getPremios().remove(premio);
        }
        return 1;
    }
}
