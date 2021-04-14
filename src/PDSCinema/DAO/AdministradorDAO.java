package PDSCinema.DAO;

import PDSCinema.DAO.ADMStrategy.AdmStrategyAbstractEvento;
import PDSCinema.model.Cupom;
import PDSCinema.model.Evento;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public interface AdministradorDAO{

    void cadastrarEvento(String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    void cadastrarCupons(String _Cupom, double tipoDeCupom);
    void cadastrarPremios(String descricao, int id, int condicao);

    Evento buscarEvento(AdmStrategyAbstractEvento evento, String nome);
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(int codigo);
    int removerEvento(AdmStrategyAbstractEvento strategyAbstractEvento, Evento evento);
    int removerCupons(Cupom cupom);
    int removerPremios(Premio premio);
}
