package PDSCinema.DAO.ADMStrategy;

import PDSCinema.model.Evento;
import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.repository.EventoRepository;

import java.util.ArrayList;

public class AdmCinema extends AdmStrategyAbstractEvento {

    @Override
    public Evento buscarEvento(String evento){
        for(Filme filme : CinemaRepository.getFilmesEmCartaz()) {
            if (filme.getName().equalsIgnoreCase(evento))
                return filme;
        }
        return null;

    }
    @Override
    public void removerEvento(Evento evento){
        CinemaRepository.getFilmesEmCartaz().remove(evento);
    }

    public ArrayList<Filme> buscarFilmeGenero(String genero){
        ArrayList<Filme> filmesPorGenero = new ArrayList<>();
        for(Filme filme : CinemaRepository.getFilmesEmCartaz()) {
            if (filme.getGenero().equalsIgnoreCase(genero))
                filmesPorGenero.add(filme);
        }
        return filmesPorGenero;
    }
}
