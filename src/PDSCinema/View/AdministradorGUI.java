package PDSCinema.View;

import PDSCinema.Controller.AdministradorController;
import PDSCinema.model.Filme;
import PDSCinema.repository.CinemaRepository;

import java.util.Scanner;

public class AdministradorGUI {
    private CinemaRepository cinemaRepository;
    private AdministradorController administradorController;

    public AdministradorGUI(CinemaRepository cinemaRepository){
        this.cinemaRepository = cinemaRepository;
        administradorController = new AdministradorController();
        Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ADM");
        int op;
        String nome, sinopse, classificacaoIndicativa, genero, diaDeEstreia;
        do{

            System.out.println("O que deseja fazer?");
            System.out.println("1 - Inserir Filme");
            System.out.println("2 - Buscar Filme");
            System.out.println("99 - Sair");
            System.out.print("> ");
            op = Integer.parseInt(in.nextLine());
            switch (op){
                case 1:
                        int duracao;
                        System.out.println("Digite o nome do filme: ");
                        nome = in.nextLine();
                        System.out.println("Digite a duracao do filme: ");
                        duracao = Integer.parseInt(in.nextLine());
                        System.out.println("Digite a sinopse: ");
                        sinopse = in.nextLine();
                        System.out.println("Digite a classificação indicativa: ");
                        classificacaoIndicativa = in.nextLine();
                        System.out.println("Digite o genero:");
                        genero = in.nextLine();
                        System.out.println("Digite o dia da estreia:");
                        diaDeEstreia = in.nextLine();
                        System.out.println(administradorController.cadastrarFilmes(cinemaRepository, nome,
                                duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia));
                        break;
                case 2: System.out.println("Digite o nome do filme:");
                        nome = in.nextLine();
                        Filme filme = administradorController.buscarFilme(cinemaRepository, nome);
                        if(filme != null){
                            System.out.println(filme.getName());
                            System.out.println(filme.getDuracao());
                            System.out.println(filme.getSinopse());
                            System.out.println(filme.getClassificacaoIndicativa());
                            System.out.println(filme.getGenero());
                            System.out.println(filme.getDiaDeEstreia());
                        }
                case 99: break;
            }
        }while (op != 99);
    }

}
