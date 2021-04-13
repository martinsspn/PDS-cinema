package PDSCinema.DAO.ClienteStrategy;

import PDSCinema.repository.CinemaRepository;

import java.io.IOException;
import java.util.List;

public class ClienteCinema extends ClienteStrategyEventoDAO{
    @Override
    public void avaliarEvento(){

    }
    @Override
    public void comprarIngressoEvento(){

    }

    public int avaliarHorario(CinemaRepository cinema, String horario, int avaliacao) throws IOException {
        int index = 0;
        List<String> horarios = cinema.getHorarios();
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
        cinema.getAvaliacoesHorarios().set(index, cinema.getAvaliacoesHorarios().get(index)+avaliacao);
        cinema.getQuantAvHorarios().set(index, cinema.getQuantAvHorarios().get(index)+1);
        return 0;
    }
}
