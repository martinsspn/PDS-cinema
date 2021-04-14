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

    void cadastrarCupons(String _Cupom, double tipoDeCupom);
    void cadastrarPremios(String descricao, int id, int condicao);

    Evento buscarEvento(String nome);
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(int codigo);
    int removerEvento(Evento evento);
    int removerCupons(Cupom cupom);
    int removerPremios(Premio premio);
}
