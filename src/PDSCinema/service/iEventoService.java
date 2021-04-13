package PDSCinema.service;


import PDSCinema.model.Administrador;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

public interface iEventoService {
    int inserirCliente(CinemaRepository cinema, String cpf, String nome);
    int removerCliente(Cliente cliente, CinemaRepository cinema);
    Cliente buscarCliente(CinemaRepository cinema, String cpf);
    List <Cliente> buscarTodosCliente(CinemaRepository cinema);
    int inserirADM(CinemaRepository cinema, String nome, String cpf);
    int removerADM(Administrador ADM, CinemaRepository cinema);
    Administrador buscarADM(String cpf, CinemaRepository cinema);
    List <Administrador> buscarTodosADM(CinemaRepository cinema);
    Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico);
    List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz);
    List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
    ArrayList<String> calcularRankingFilme(CinemaRepository cinemaRepository, List<Filme> filmesEmCartaz);
    ArrayList<String> calcularRankingHorarios(CinemaRepository cinemaRepository, List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
}
