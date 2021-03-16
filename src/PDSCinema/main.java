package PDSCinema;

import PDSCinema.service.*;

import java.util.List;

public class main {
    public static void main(String[] args){
        iCinemaService ics = new CinemaService();
        iAdministradorService ids = new AdmistradorService();
        //ics.inserirADM(ics.getCinema(), "João", "019291");
        ids.cadastrarFilmes(ics.getCinema(), "esqueceram de mim", 120, "uma sinopse qualquer", "15 anos", "comedia"
        , "10/01/2000");
        ids.cadastrarFilmes(ics.getCinema(), "Velozes e Furiosos", 110, "Um monte de carro voando", "18 Anos", "Ação"
        , "02/02/2002");
        ids.cadastrarFilmes(ics.getCinema(), "Harry Potter", 130, "Poderzinhos e varinhas", "18 Anos", "Magia"
        , "03/04/2004");

        for(int i=0; i<ics.getCinema().getFilmesEmCartaz().size(); i++){
            System.out.println(ics.getCinema().getFilmesEmCartaz().get(i).getName());
        }
        if(ics.inserirCliente("38721837", "Gabriel") == -1){
            System.out.println("Não cadastrado");
        }else{
            System.out.println("Cliente cadastrado");
        }

        if(ics.inserirCliente("38293823", "Acsa") == -1){
            System.out.println("Não cadastrado");
        }else{
            System.out.println("Cliente cadastrado");
        }
        if(ics.inserirCliente("38293823", "Gabriel 2") == -1){
            System.out.println("Não cadastrado");
        }else{
            System.out.println("Cliente cadastrado");
        }
        //System.out.println(ics.buscarCliente("38721837", ics.getCinema()).getCliente().getNome());
        //ics.buscarCliente("38721837", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(0), 5);
        //ics.buscarCliente("38721837", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(0), 5);
        //ics.buscarCliente("38721837", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(0), 4);
        //ics.buscarCliente("38721837", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(0), 3);
        //ics.buscarCliente("38721837", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(1), 4);
        //ics.buscarCliente("38721837", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(2), 3);
        //ics.buscarCliente("38293823", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(1), 5);
        //ics.buscarCliente("38293823", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(1), 5);
        //ics.buscarCliente("38293823", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(1), 5);
        //ics.buscarCliente("38293823", ics.getCinema()).avaliarFilme(ics.getCinema().getFilmesEmCartaz().get(2), 2);

        for(double i: ics.calcularMediaAvaliacaoFilmes(ics.getCinema().getFilmesEmCartaz())){
            System.out.println(i);
        }
        List<String> filmes = ics.calcularRankingFilme(ics.getCinema().getFilmesEmCartaz());
        System.out.println("");
        for(int i=filmes.size()-1;i>=0;i--){
            System.out.println((filmes.size()-i) + " " + filmes.get(i));
        }
    }
}