package PDSCinema.DAO.ClienteStrategy;

import PDSCinema.DAO.ClienteStrategy.ClienteStrategyEventoDAO;
import PDSCinema.model.Evento;
import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;


import java.io.IOException;
import java.util.List;

public class ClienteCinema extends ClienteStrategyEventoDAO {
    @Override
    public void avaliarEvento(Evento evento, int avaliacao){
        int avaliacoes = evento.getAvaliacoes();
        evento.setAvaliacoes(avaliacoes+avaliacao);
        evento.setQuantAvaliacoes(evento.getQuantAvaliacoes()+1);
    }


    public int avaliarHorario(String horario, int avaliacao) throws IOException {
        int index = 0;
        List<String> horarios = CinemaRepository.getHorarios();
        for(int i=0;i<horarios.size();i++) {
            if(horarios.get(i).equals(horario)) {
                index = i;
                break;
            }else {
                if(i == horarios.size()-1) {
                    throw new IOException();
                }
            }
        }
        CinemaRepository.getAvaliacoesHorarios().set(index, CinemaRepository.getAvaliacoesHorarios().get(index)+avaliacao);
        CinemaRepository.getQuantAvHorarios().set(index, CinemaRepository.getQuantAvHorarios().get(index)+1);
        return 0;
    }
}
