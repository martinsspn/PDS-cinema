package PDSCinema.Controller;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.EventoService;
import java.util.ArrayList;
import java.util.List;

public class EventoController {
    private final EventoService cinema;
    public EventoController(){
        this.cinema = new EventoService();
    }
    public String inserirCliente(String cpf, String nome){
        int status = this.cinema.inserirCliente(cpf, nome);
        if(status == 0){
            return ("Cliente cadastrado com sucesso!");
        }else{
            return ("Cliente não cadastrado!");
        }
    }
    public String removerCliente(Cliente cliente){
        int status = cinema.removerCliente(cliente);
        if(status == 0){
            return ("Cliente removido com sucesso!");
        }else{
            return ("Cliente não cadastrado!");
        }
    }
    public Cliente buscarCliente(String cpf){
        Cliente cliente = this.cinema.buscarCliente(cpf);
        if(cliente != null){
            //System.out.println("Cliente encontrado com sucesso");
            return cliente;
        }else{
            //System.out.println("Cliente não encontrado!");
            return null;
        }
    }
    public List<Cliente> buscarTodosCliente(){
        List<Cliente> clientes = this.cinema.buscarTodosCliente();
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
    public String inserirADM(String nome, String cpf){
        int status = this.cinema.inserirADM(nome, cpf);
        if(status == 0) {
            return ("Administrador inserido com sucesso!");
        }else{
            return ("Erro ao cadastrar o administrador!");
        }
    }
    public String removerADM(Administrador ADM){
        int status = this.cinema.removerADM(ADM);
        if(status == 0){
            return ("Administrador removido com sucesso!");
        }else{
            return ("Administrador não encontrado!");
        }
    }
    public Administrador buscarADM(String cpf){
        Administrador adm = cinema.buscarADM(cpf);
        if(adm != null){
            System.out.println ("Administrador encontrado com sucesso!");
            return adm;
        }else{
            System.out.println ("Administrador não encontrado!");
            return null;
        }
    }
    public List <Administrador> buscarTodosADM(){
        List<Administrador> adms = this.cinema.buscarTodosADM();
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
            return media;
        }else{
            return -1.0;
        }
    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz){
        List<Double> medias = cinema.calcularMediaAvaliacaoFilmes(filmesEmCartaz);
        if(medias != null){
            System.out.println ("Medias calculadas com sucesso!");
            return medias;
        }else{
            System.out.println ("Erro ao cacular médias!");
            return null;
        }
    }
    public List<Double> calcularMediaAvaliacaoHorario(CinemaRepository cinemaRepository, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
        List<Double> medias = cinema.calcularMediaAvaliacaoHorario(avaliacoesHorarios, quantAvHorarios);
        if(medias != null){
            System.out.println ("Medias calculadas com sucesso!");
            return medias;
        }else{
            System.out.println ("Erro ao cacular médias!");
            return null;
        }
    }
    public ArrayList<String> calcularRankingFilme(CinemaRepository cinemaRepository, List<Filme> filmesEmCartaz){
        ArrayList<String> ranking = cinema.calcularRankingFilme(filmesEmCartaz);
        if(ranking != null){
            return ranking;
        }else{
            return null;
        }
    }
    public ArrayList<String> calcularRankingHorarios(CinemaRepository cinemaRepository, List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
        ArrayList<String> ranking = cinema.calcularRankingHorarios(horarios, avaliacoesHorarios, quantAvHorarios);
        if(ranking != null){
            return ranking;
        }else{
            return null;
        }
    }
}
