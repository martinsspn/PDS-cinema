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
    public CinemaController(){
        this.cinema = new CinemaService();
    }
    public String inserirCliente(CinemaRepository cinema, String cpf, String nome){
        int status = this.cinema.inserirCliente(cinema ,cpf, nome);
        if(status == 0){
            return ("Cliente cadastrado com sucesso");
        }else{
            return ("Cliente não cadastrado!");
        }
    }
    public String removerCliente(Cliente cliente, CinemaRepository _cinema){
        int status = cinema.removerCliente(cliente, _cinema);
        if(status == 0){
            return ("Cliente removido com sucesso");
        }else{
            return ("Cliente não cadastrado!");
        }
    }
    public Cliente buscarCliente(CinemaRepository cinema, String cpf){
        Cliente cliente = this.cinema.buscarCliente(cinema, cpf);
        if(cliente != null){
            //System.out.println("Cliente encontrado com sucesso");
            return cliente;
        }else{
            //System.out.println("Cliente não encontrado!");
            return null;
        }
    }
    public List<Cliente> buscarTodosCliente(CinemaRepository cinema){
        List<Cliente> clientes = this.cinema.buscarTodosCliente(cinema);
        /*if(clientes != null){
            System.out.println ("Clientes encontrados com sucesso");
            return clientes;
        }else {
            System.out.println ("Nenhum cliente encontrado!");
            return null;
        }

         */
        return clientes;
    }
    public String inserirADM(CinemaRepository cinema, String nome, String cpf){
        int status = this.cinema.inserirADM(cinema, nome, cpf);
        if(status == 0) {
            return ("Administrador inserido com sucesso");
        }else{
            return ("Erro ao cadastrar o administrador!");
        }
    }
    public String removerADM(Administrador ADM, CinemaRepository cinema){
        int status = this.cinema.removerADM(ADM, cinema);
        if(status == 0){
            return ("Administrador removido com sucesso");
        }else{
            return ("Administrador não encontrado!");
        }
    }
    public Administrador buscarADM(String cpf, CinemaRepository _cinema){
        Administrador adm = cinema.buscarADM(cpf, _cinema);
        if(adm != null){
            System.out.println ("Administrador encontrado com sucesso");
            return adm;
        }else{
            System.out.println ("Administrador não encontrado");
            return null;
        }
    }
    public List <Administrador> buscarTodosADM(CinemaRepository cinema){
        List<Administrador> adms = this.cinema.buscarTodosADM(cinema);
        /*if(adms.size() > 0){
            //System.out.println ("Adminsitradores encontrados com sucesso");
            return adms;
        }else{
            System.out.println ("Nenhum administrador encontrado!");
            return null;
        }*/
        return adms;
    }
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
        Double media = cinema.calcularMediaAvaliacaoServico(avaliacoesServico, quantAvServico);
        if(media > 0){
            System.out.println ("Média calculada com sucesso");
            return media;
        }else{
            System.out.println ("Nenhuma avaliação cadastrada!");
            return 0.;
        }
    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz){
        List<Double> medias = cinema.calcularMediaAvaliacaoFilmes(filmesEmCartaz);
        if(medias != null){
            System.out.println ("Medias calculadas com sucesso");
            return medias;
        }else{
            System.out.println ("Erro ao cacular médias!");
            return null;
        }
    }
    public List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
        List<Double> medias = cinema.calcularMediaAvaliacaoHorario(avaliacoesHorarios, quantAvHorarios);
        if(medias != null){
            System.out.println ("Medias calculadas com sucesso");
            return medias;
        }else{
            System.out.println ("Erro ao cacular médias!");
            return null;
        }
    }
    public ArrayList<String> calcularRankingFilme(List<Filme> filmesEmCartaz){
        ArrayList<String> ranking = cinema.calcularRankingFilme(filmesEmCartaz);
        if(ranking != null){
            System.out.println ("Ranking calculado com sucesso");
            return ranking;
        }else{
            System.out.println ("Erro ao calcular ranking");
            return null;
        }
    }
    public ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
        ArrayList<String> ranking = cinema.calcularRankingHorarios(horarios, avaliacoesHorarios, quantAvHorarios);
        if(ranking != null){
            System.out.println ("Ranking calculado com sucesso");
            return ranking;
        }else{
            System.out.println("Erro ao calcular ranking");
            return null;
        }
    }
}
