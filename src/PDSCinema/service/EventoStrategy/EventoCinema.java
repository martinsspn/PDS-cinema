package PDSCinema.service.EventoStrategy;

import PDSCinema.model.Evento;
import PDSCinema.model.Filme;
import PDSCinema.repository.EventoRepository;

import java.util.ArrayList;
import java.util.List;

public class EventoCinema extends EventoStrategyAbstractEvento{

    @Override
    public ArrayList<String> calcularRanking(List<Evento> listaDeEventos){
        ArrayList<Filme> filmes = new ArrayList<>();
        for(Evento evento : listaDeEventos){
            filmes.add((Filme) evento);
        }
        List<Double> medias = calcularMediaAvaliacaoEvento(listaDeEventos);
        ArrayList<String> rankingFilmes = new ArrayList<>();
        EventoRepository.setMedias(medias);

        for(Filme filme : filmes)
            rankingFilmes.add(filme.getName());

        int i, j, min;
        Double aux;
        String aux2;
        for (i = 0; i < (listaDeEventos.size())-1; i++){
            min = i;
            for (j = (i + 1); j < listaDeEventos.size(); j++) {
                if (medias.get(j) < medias.get(min))
                    min = j;
            }
            if (i != min) {
                aux = medias.get(i);
                aux2 = rankingFilmes.get(i);
                medias.set(i, medias.get(min));
                medias.set(min, aux);
                rankingFilmes.set(i, rankingFilmes.get(min));
                rankingFilmes.set(min, aux2);
            }
        }
        return rankingFilmes;
    }

    public List<Double> calcularMediaAvaliacaoEvento(List<Evento> eventos) {
        try{
            List<Double> valor = new ArrayList<>();
            for (Evento evento : eventos) {
                if(evento.getQuantAvaliacoes() == 0){
                    valor.add(((double)(evento.getAvaliacoes())));
                }else{
                    valor.add(((double)(evento.getAvaliacoes()) / (double)(evento.getQuantAvaliacoes())));
                }
            }
            return valor;
        }catch (ArithmeticException e){
            return null;
        }
    }
}
