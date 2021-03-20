package PDSCinema.View;

import PDSCinema.Controller.ClienteController;
import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.ClienteService;

import java.util.Scanner;

public class ClienteGUI {
    private CinemaRepository cinemaRepository;

    public ClienteGUI(CinemaRepository cinemaRepository){
        Scanner in = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ClienteController clienteController = new ClienteController(clienteService);
        boolean running = true;
        this.cinemaRepository = cinemaRepository;
        System.out.println("Bem vindo ao cinema!!!");
        while(running){
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ver filmes em cartaz");
            System.out.println("2 - Sair");
            switch(Integer.parseInt(in.nextLine())){
                case 1: for(Filme f: cinemaRepository.getFilmesEmCartaz()){
                            System.out.println(f.getName());
                        }
                        break;
                case 2: running = false;
                        break;
                default: System.out.println("opção inválida");
            }
        }
    }
}
