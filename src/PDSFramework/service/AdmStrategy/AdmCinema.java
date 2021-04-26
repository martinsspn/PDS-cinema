package PDSFramework.service.AdmStrategy;

import PDSFramework.DAO.SingletonEventoDAO;
import PDSFramework.model.Evento;
import PDSFramework.model.Filme;
import PDSFramework.repository.CinemaRepository;

import java.util.ArrayList;

public class AdmCinema extends AdmStrategyAbstractEvento{
    private PDSFramework.DAO.ADMStrategy.AdmCinema admStrategyAbstractEvento = (PDSFramework.DAO.ADMStrategy.AdmCinema) SingletonEventoDAO.getAdmStrategyAbstractEvento();

    public ArrayList<Filme> buscarFilmeGenero(String genero){
        if(!CinemaRepository.getFilmesEmCartaz().isEmpty() && !genero.isEmpty()){
            return admStrategyAbstractEvento.buscarFilmeGenero(genero);
        }
        else{
            return null;
        }
    }
    @Override
    public int removerEvento(Evento evento){
        if(CinemaRepository.getFilmesEmCartaz().contains(evento)) {
            SingletonEventoDAO.getAdm().removerEvento(evento);
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public Evento buscarEvento(String evento){
        if(!CinemaRepository.getFilmesEmCartaz().isEmpty()) {
            return SingletonEventoDAO.getAdm().buscarEvento(evento);
        }else{
            return null;
        }
    }

}
