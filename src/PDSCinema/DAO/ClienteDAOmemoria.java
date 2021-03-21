package PDSCinema.DAO;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOmemoria implements ClienteDAO{

    @Override
    public int avaliarServico(CinemaRepository cinema, int avaliacao) {
        int avaliacoes = cinema.getAvaliacoesServico();
        cinema.setAvaliacoesServico(avaliacoes+avaliacao);
        cinema.setQuantAvServico(cinema.getQuantAvServico()+1);
        return 0;
    }

    @Override
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

    @Override
    public int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo)  {
        cliente.getCuponsAtivos().add(cinema.getListaDeCupons().get(codigo));
        return 0;
    }

    @Override
    public String compartilharCupom(Cliente cliente) {
        String compartilhar = "Cupom: " + cliente.getCuponsUsados().get(0).getCodigo()
                + "\n" + "Valor do Cupom: R$" + cliente.getCuponsUsados().get(0).getTipoDeCupom() + "\n";
        return compartilhar;
    }

    @Override
    public Premio resgatarPremio(CinemaRepository cinema, Cliente cliente, int codigo){
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
    public int avaliarFilme(Filme filme, int avaliacao) {
        int avaliacoes = filme.getAvaliacoes();
        filme.setAvaliacoes(avaliacoes+avaliacao);
        filme.setQuantAvaliacoes(filme.getQuantAvaliacoes()+1);
        return 0;
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
}
