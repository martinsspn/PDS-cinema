package PDSFramework.service;


import PDSFramework.model.Administrador;
import PDSFramework.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface iEventoService {
    int inserirCliente(String cpf, String nome);
    int removerCliente(Cliente cliente);
    Cliente buscarCliente(String cpf);
    List <Cliente> buscarTodosCliente();
    int inserirADM(String nome, String cpf);
    int removerADM(Administrador ADM);
    Administrador buscarADM(String cpf);
    List <Administrador> buscarTodosADM();
    Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico);
    List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
    ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios);
}
