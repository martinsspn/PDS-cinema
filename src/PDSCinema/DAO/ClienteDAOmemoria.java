package PDSCinema.DAO;


import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;

import java.io.IOException;
import java.util.List;

public class ClienteDAOmemoria implements ClienteDAO{
    Cliente cliente = new Cliente();

    @Override
    public int avaliarServico(Cinema cinema, int avaliacao) {
        int avaliacoes = cinema.getAvaliacoesServico();
        cinema.setAvaliacoesServico(avaliacoes+avaliacao);
        cinema.setQuantAvServico(cinema.getQuantAvServico()+1);
        return 0;
    }

    @Override
    public int avaliarHorario(Cinema cinema, String horario, int avaliacao) throws IOException {
        int index = 0;
        List<String> horarios = cinema.getHorarios();
        for(int i=0;i<horarios.size();i++) {
            if(horarios.get(i).equals(horario)) {
                index = i;
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

    @Override
    public int utilizarCupom() {
        return 0;
    }

    @Override
    public int compartilharCupom() {
        return 0;
    }

    @Override
    public int resgatarPremio() {
        return 0;
    }

    @Override
    public int avaliarFilme(Filme filme, int avaliacao) {
        int avaliacoes = filme.getAvaliacoes();
        filme.setAvaliacoes(avaliacoes+avaliacao);
        filme.setQuantAvaliacoes(filme.getQuantAvaliacoes()+1);
        return 0;
    }

    @Override
    public int comprarIngresso(Ingresso ingresso) {
        cliente.getIngressos().add(ingresso);
        return 0;
    }
}
