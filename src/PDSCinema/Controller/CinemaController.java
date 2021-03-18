package PDSCinema.Controller;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.CinemaService;
import java.util.ArrayList;
import java.util.List;

public class CinemaController {
    private final CinemaService cinema;
    CinemaController(CinemaService cinema){
        this.cinema = cinema;
    }
    public int inserirCliente(String cpf, String nome){
        int status = cinema.inserirCliente(cpf, nome);
        if(status == 0){
            System.out.println("Cliente cadastrado com sucesso");
            return 0;
        }else{
            System.out.println("Cliente não cadastrado!");
            return -1;
        }
    }
    public int removerCliente(Cliente cliente, CinemaRepository cinema){
        int status = this.cinema.removerCliente(cliente, cinema);
        if(status == 0){
            System.out.println("Cliente removido com sucesso");
            return 0;
        }else{
            System.out.println("Cliente não cadastrado!");
            return -1;
        }
    }
    public Cliente buscarCliente(CinemaRepository cinema, String cpf){
        Cliente cliente = this.cinema.buscarCliente(cinema, cpf);
        if(cliente != null){
            System.out.println("Cliente encontrado com sucesso");
            return cliente;
        }else{
            System.out.println("Cliente não encontrado!");
            return null;
        }
    }
    public List<Cliente> buscarTodosCliente(){
        List<Cliente> clientes = cinema.buscarTodosCliente();
        if(clientes != null){
            System.out.println("Clientes encontrados com sucesso");
            return clientes;
        }else {
            System.out.println("Nenhum cliente encontrado!");
            return null;
        }
    }
    public int inserirADM(CinemaRepository cinema, String nome, String cpf){
        int status = this.cinema.inserirADM(cinema, nome, cpf);
        if(status == 0) {
            System.out.println("Administrador inserido com sucesso");
            return 0;
        }else{
            System.out.println("Erro ao cadastrar o administrador!");
            return -1;
        }
    }
    public int removerADM(Administrador ADM, CinemaRepository cinema){
        int status = this.cinema.removerADM(ADM, cinema);
        if(status == 0){
            System.out.println("Administrador removido com sucesso");
            return 0;
        }else{
            System.out.println("Administrador não encontrado!");
            return -1;
        }
    }
    public Administrador buscarADM(String cpf, CinemaRepository cinema){
        Administrador adm = this.cinema.buscarADM(cpf, cinema);
        if(adm != null){
            System.out.println("Administrador encontrado com sucesso");
            return adm;
        }else{
            System.out.println("Administrador não encontrado");
            return null;
        }
    }
    public List <Administrador> buscarTodosADM(){
        List<Administrador> adms = cinema.buscarTodosADM();
        if(adms != null){
            System.out.println("Adminsitradores encontrados com sucesso");
            return adms;
        }else{
            System.out.println("Nenhum administrador encontrado!");
            return null;
        }
    }
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
        Double media = cinema.calcularMediaAvaliacaoServico(avaliacoesServico, quantAvServico);
        if(media > 0){
            System.out.println("Média calculada com sucesso");
            return media;
        }else{
            System.out.println("Nenhuma avaliação cadastrada!");
            return 0.;
        }
    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz){
        List<Double> medias = cinema.calcularMediaAvaliacaoFilmes(filmesEmCartaz);
        if(medias != null){
            System.out.println("Medias calculadas com sucesso");
            return medias;
        }else{
            System.out.println("Erro ao cacular médias!");
            return null;
        }
    }
    public List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
        List<Double> medias = cinema.calcularMediaAvaliacaoHorario(avaliacoesHorarios, quantAvHorarios);
        if(medias != null){
            System.out.println("Medias calculadas com sucesso");
            return medias;
        }else{
            System.out.println("Erro ao cacular médias!");
            return null;
        }
    }
    public ArrayList<String> calcularRankingFilme(List<Filme> filmesEmCartaz){
        ArrayList<String> ranking = cinema.calcularRankingFilme(filmesEmCartaz);
        if(ranking != null){
            System.out.println("Ranking calculado com sucesso");
            return ranking;
        }else{
            System.out.println("Erro ao calcular ranking");
            return null;
        }
    }
    public ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
        ArrayList<String> ranking = cinema.calcularRankingHorarios(horarios, avaliacoesHorarios, quantAvHorarios);
        if(ranking != null){
            System.out.println("Ranking calculado com sucesso");
            return ranking;
        }else{
            System.out.println("Erro ao calcular ranking");
            return null;
        }
    }
}
