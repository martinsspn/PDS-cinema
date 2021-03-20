package PDSCinema.View;

import PDSCinema.Controller.AdministradorController;
import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorGUI {

    private final CinemaRepository cinemaRepository;
    private final AdministradorController administradorController;

    public AdministradorGUI(CinemaRepository cinemaRepository){
        this.cinemaRepository = cinemaRepository;
        administradorController = new AdministradorController();
        Scanner in = new Scanner(System.in);
        System.out.println("Seja bem vindo ADM");
        int op = 99;
        do{

            System.out.println("O que deseja fazer?");
            System.out.println("1 - Inserir Filme");
            System.out.println("2 - Buscar Filme");
            System.out.println("3 - Buscar filme por gênero");
            System.out.println("4 - Remover Filme");
            System.out.println("5 - Inserir Cupom");
            System.out.println("6 - Buscar Cupons");
            System.out.println("7 - Remover Cupom");
            System.out.println("8 - Inserir Premio");
            System.out.println("9 - Buscar Premio");
            System.out.println("10 - Remover Premio");
            System.out.println("0 - Sair");
            System.out.print("> ");
            String Sop = in.nextLine();
            if(!Sop.isEmpty())
                op = Integer.parseInt(Sop);
            String nome, sinopse, classificacaoIndicativa, genero, diaDeEstreia, status;

            int codigoPremio = 0, duracao = 0, condicaoPremio = 0;
            double tipoCupom = 0;
            switch (op){
                case 1:
                    int sel = 1;
                    do {
                        System.out.println("Digite o nome do filme: ");
                        nome = in.nextLine();
                        System.out.println("Digite a duracao do filme: ");
                        String Sduracao = in.nextLine();
                        if(!Sduracao.isEmpty())
                            duracao = Integer.parseInt(Sduracao);
                        System.out.println("Digite a sinopse: ");
                        sinopse = in.nextLine();
                        System.out.println("Digite a classificação indicativa: ");
                        classificacaoIndicativa = in.nextLine();
                        System.out.println("Digite o genero:");
                        genero = in.nextLine();
                        System.out.println("Digite o dia da estreia:");
                        diaDeEstreia = in.nextLine();
                        status = administradorController.cadastrarFilmes(cinemaRepository, nome,
                                duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
                        System.out.println(status);
                        System.out.println("Deseja continuar? 0 - não 1 - sim");
                        String Ssel = in.nextLine();
                        if(!Ssel.isEmpty())
                            sel = Integer.parseInt(Ssel);
                        if(sel == 0) {
                            System.out.println("aaaaaaaaa");
                            break;
                        }
                    }while(sel == 1);
                    break;
                case 2:
                    System.out.println("Digite o nome do filme:");
                    nome = in.nextLine();
                    Filme filme = administradorController.buscarFilme(cinemaRepository, nome);
                    if(filme != null){
                        System.out.println(filme.getName());
                        System.out.println(filme.getDuracao());
                        System.out.println(filme.getSinopse());
                        System.out.println(filme.getClassificacaoIndicativa());
                        System.out.println(filme.getGenero());
                        System.out.println(filme.getDiaDeEstreia());
                    }else{
                        System.out.println("Filme não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do genero:");
                    genero = in.nextLine();
                    ArrayList<Filme> filmeGenero = administradorController.buscarFilmeGenero(cinemaRepository, genero);
                    if(!filmeGenero.isEmpty()){
                        for(Filme f : filmeGenero){
                            System.out.println(f.getName());
                        }
                    }else{
                        System.out.println("Nenhum filme do gênero " + genero + " foi encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do filme:");
                    String nomeFilme = in.nextLine();
                    Filme f = administradorController.buscarFilme(cinemaRepository, nomeFilme);
                    status = administradorController.removerFilmes(cinemaRepository, f);
                    System.out.println(status);
                    break;
                case 5:
                    System.out.print("Código do cupom: ");
                    String nomeCupom = in.nextLine();
                    System.out.print("Valor do desconto: ");
                    String StipoCupom = in.nextLine();
                    if(!StipoCupom.isEmpty())
                        tipoCupom = Double.parseDouble(in.nextLine());
                    status = administradorController.cadastrarCupons(cinemaRepository, nomeCupom, tipoCupom);
                    System.out.println(status);
                    break;
                case 6:
                    System.out.print("Código do cupom: ");
                    nomeCupom = in.nextLine();
                    Cupom cupom = administradorController.buscarCupons(cinemaRepository, nomeCupom);
                    if(cupom != null) {
                        System.out.println(cupom.getCodigo());
                        System.out.println(cupom.getTipoDeCupom());
                    }else{
                        System.out.println("Cupom não encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Código do cupom: ");
                    nomeCupom = in.nextLine();
                    cupom = administradorController.buscarCupons(cinemaRepository, nomeCupom);
                    if(cupom != null) {
                        System.out.println(administradorController.removerCupons(cinemaRepository, cupom));
                    }else{
                        System.out.println("Cupom não cadastrado.");
                    }
                    break;
                case 8:
                    System.out.println("Código do prêmio:");
                    String ScodigoPremio = in.nextLine();
                    if(!ScodigoPremio.isEmpty())
                        codigoPremio = Integer.parseInt(ScodigoPremio);
                    System.out.println("Descrição do prêmio: ");
                    String descricaoPremio = in.nextLine();
                    System.out.println("Condição: ");
                    String ScondicaoPremio = in.nextLine();
                    if(!ScondicaoPremio.isEmpty()){
                        condicaoPremio = Integer.parseInt(ScondicaoPremio);
                    }
                    status = administradorController.cadastrarPremios(cinemaRepository, descricaoPremio, codigoPremio, condicaoPremio);
                    System.out.println(status);
                    break;
                case 9:
                    System.out.print("Código do prêmio: ");
                    ScodigoPremio = in.nextLine();
                    if(!ScodigoPremio.isEmpty())
                        codigoPremio = Integer.parseInt(ScodigoPremio);
                    Premio premio = administradorController.buscarPremio(cinemaRepository, codigoPremio);
                    if(premio != null) {
                        System.out.println(premio.getIdPremio());
                        System.out.println(premio.getDescricao());
                    }else{
                        System.out.println("Premio não encontrado.");
                    }
                    break;
                case 10:
                    System.out.print("Código do premio: ");
                    ScodigoPremio = in.nextLine();
                    if(!ScodigoPremio.isEmpty())
                        codigoPremio = Integer.parseInt(ScodigoPremio);
                    premio = administradorController.buscarPremio(cinemaRepository, codigoPremio);
                    if(premio != null) {
                        System.out.println(administradorController.removerPremios(cinemaRepository, premio));
                    }else{
                        System.out.println("Premio não cadastrado.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Seleção inválida!");
            }
        }while (op != 0);
    }




// precisa ter um meio de voltar pro cinema no final, por exemplo perguntar se ele quer sair
}