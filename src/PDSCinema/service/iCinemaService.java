package PDSCinema.service;


import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

public interface iCinemaService {
    int inserirCliente(String cpf, String nome);
    int removerCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    List <Cliente> buscarTodosCliente();
    int inserirADM(String nome, String cpf);
    int removerADM(Administrador ADM);
    Administrador buscarADM(String cpf);
    List <Administrador> buscarTodosADM();
    Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico);
    List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz);
    List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
    Cinema getCinema();
    ArrayList<String> calcularRankingFilme(List<Filme> filmesEmCartaz);
    ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
}
