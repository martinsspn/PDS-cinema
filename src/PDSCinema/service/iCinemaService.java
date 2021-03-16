package PDSCinema.service;


import PDSCinema.model.Administrador;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

public interface iCinemaService {
    int inserirCliente(String cpf, String nome);
    int removerCliente(Cliente cliente, CinemaRepository cinema);
    Cliente buscarCliente(CinemaRepository cinema, String cpf);
    List <Cliente> buscarTodosCliente();
    int inserirADM(CinemaRepository cinema, String nome, String cpf);
    int removerADM(Administrador ADM, CinemaRepository cinema);
    Administrador buscarADM(String cpf, CinemaRepository cinema);
    List <Administrador> buscarTodosADM();
    Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico);
    List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz);
    List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
    ArrayList<String> calcularRankingFilme(List<Filme> filmesEmCartaz);
    ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
}
