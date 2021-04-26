package PDSFramework.View;

import PDSFramework.Controller.AdministradorController;
import PDSFramework.Controller.EventoController;
import PDSFramework.model.Administrador;
import PDSFramework.model.Cliente;
import PDSFramework.model.Evento;
import PDSFramework.model.Filme;
import PDSFramework.repository.CinemaRepository;
import PDSFramework.repository.EventoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaGUI {
    public CinemaGUI() {
        EventoController eventoController = new EventoController();
        AdministradorController admi = new AdministradorController();
        preencherCinema(eventoController, admi);
        CinemaRepository.setHorarios();
        boolean val = true;
        Cliente cliente = new Cliente();
        while (val) {
            System.out.println("Bem vindo ao cinema!");
            System.out.println("Escolha a opção:");
            System.out.println("1 - Entrar como administrador");
            System.out.println("2 - Entrar como cliente");
            System.out.println("3 - Ver ranking");
            System.out.println("4 - Sair");
            Scanner in = new Scanner(System.in);
            String sel = in.nextLine();
            int op = 0;
            if(!sel.isEmpty())
                op = Integer.parseInt(sel);
            switch (op) {
                case 1:
                    if (eventoController.buscarTodosADM().isEmpty()) {
                        System.out.println("Não há nenhum administrador cadastrado!");
                        System.out.println("Por favor, cadastre-se");
                        String nome;
                        String CPF;
                        System.out.print("Nome: ");
                        nome = in.nextLine();
                        System.out.print("CPF: ");
                        CPF = in.nextLine();
                        String status = eventoController.inserirADM(nome, CPF);
                        System.out.println(status);
                        if (status.equals("Erro ao cadastrar o administrador!")) {
                            while (status.equals("Erro ao cadastrar o administrador!")) {
                                System.out.println("Tente novamente");
                                System.out.print("Nome: ");
                                nome = in.nextLine();
                                System.out.print("CPF: ");
                                CPF = in.nextLine();
                                status = eventoController.inserirADM(nome, CPF);
                                System.out.println(status);
                            }
                        }
                    } else {
                        Administrador adm;
                        String CPF;
                        System.out.println("Digite seu CPF");
                        CPF = in.nextLine();
                        adm = eventoController.buscarADM(CPF);
                        if (adm == null) {
                            boolean val3 = true;
                            while (val3) {
                                System.out.println("CPF inválido ou não cadastrado.");
                                System.out.println("1 - Tentar novamente");
                                System.out.println("2 - Cadastrar-se");
                                String Ssel2 = in.nextLine();
                                int sel2 = 3;
                                if(!Ssel2.isEmpty())
                                    sel2 = Integer.parseInt(Ssel2);
                                switch (sel2) {
                                    case 1:
                                        boolean trying = true;
                                        while (adm == null && trying) {
                                            System.out.println("Digite seu CPF: ");
                                            CPF = in.nextLine();
                                            adm = eventoController.buscarADM(CPF);
                                            if (adm == null) {
                                                System.out.println("Deseja desistir? 0 - não 1 - sim");
                                                int input = Integer.parseInt(in.nextLine());
                                                if (input == 1) {
                                                    trying = false;
                                                }
                                            } else
                                                break;
                                        }
                                        val3 = false;
                                        break;
                                    case 2:
                                        System.out.println("Nome: ");
                                        String nome = in.nextLine();
                                        String status = eventoController.inserirADM(CPF, nome);
                                        System.out.println(status);
                                        while (status.equals("Erro ao cadastrar o administrador!")) {
                                            System.out.println("Tente novamente");
                                            System.out.print("Nome: ");
                                            nome = in.nextLine();
                                            System.out.print("CPF: ");
                                            CPF = in.nextLine();
                                            status = eventoController.inserirADM(nome, CPF);
                                            System.out.println(status);
                                        }
                                        val3 = false;
                                        break;
                                    default:
                                        System.out.println("Seleção inválida");
                                }
                            }
                        }
                    }
                    //interace adm
                    AdministradorGUI administradorGUI = new AdministradorGUI();
                    val = true;
                    break;
                case 2:
                    if (eventoController.buscarTodosCliente().isEmpty()) {
                        System.out.println("Não há nenhum cliente cadastrado!");
                        System.out.println("Por favor, cadastre-se");
                        String nome;
                        String CPF;
                        System.out.print("Nome: ");
                        nome = in.nextLine();
                        System.out.print("CPF: ");
                        CPF = in.nextLine();
                        String status = eventoController.inserirCliente(CPF, nome);
                        System.out.println(status);
                        if (status.equals("Erro ao cadastrar o cliente!")) {
                            while (status.equals("Erro ao cadastrar o cliente!")) {
                                System.out.println("Tente novamente");
                                System.out.print("Nome: ");
                                nome = in.nextLine();
                                System.out.print("CPF: ");
                                CPF = in.nextLine();
                                status = eventoController.inserirCliente(CPF, nome);
                                System.out.println(status);
                            }
                        }
                        cliente = eventoController.buscarCliente(CPF);
                    } else {
                        String CPF;
                        System.out.println("Digite seu CPF");
                        CPF = in.nextLine();
                        cliente = eventoController.buscarCliente(CPF);
                        if (cliente == null) {
                            boolean val3 = true;
                            while (val3) {
                                System.out.println("CPF inválido ou não cadastrado.");
                                System.out.println("1 - Tentar novamente");
                                System.out.println("2 - Cadastrar-se");
                                int sel2 = Integer.parseInt(in.nextLine());
                                switch (sel2) {
                                    case 1:
                                        boolean trying = true;
                                        while (cliente == null && trying) {
                                            System.out.println("Digite seu CPF: ");
                                            CPF = in.nextLine();
                                            cliente = eventoController.buscarCliente(CPF);
                                            if (cliente == null) {
                                                System.out.println("Deseja desistir?\n0 - não\n1 - sim");
                                                int input = in.nextInt();
                                                if (input == 1) {
                                                    trying = false;
                                                }
                                            }
                                        }
                                        val3 = false;
                                        break;
                                    case 2:
                                        System.out.println("Nome: ");
                                        String nome = in.nextLine();
                                        String status = eventoController.inserirCliente(CPF, nome);
                                        System.out.println(status);
                                        while (status.equals("Erro ao cadastrar o cliente!")) {
                                            System.out.println("Tente novamente");
                                            System.out.print("Nome: ");
                                            nome = in.nextLine();
                                            System.out.print("CPF: ");
                                            CPF = in.nextLine();
                                            status = eventoController.inserirCliente(CPF, nome);
                                            System.out.println(status);
                                        }
                                        cliente = eventoController.buscarCliente(CPF);
                                        val3 = false;
                                        break;
                                    default:
                                        System.out.println("Seleção inválida");
                                }
                            }
                        }
                    }
                    ClienteGUI clienteGUI = new ClienteGUI(cliente);
                    val = true;
                    break;
                case 3:
                    List<String> ranking;
                    int escolha = -1;
                    do {
                        System.out.println("Escolha qual ranking você deseja ver:");
                        System.out.println("1 - Nota serviços");
                        System.out.println("2 - Horários");
                        System.out.println("3 - Filmes");
                        String Sescolha = in.nextLine();
                        if (!Sescolha.isEmpty())
                            escolha = Integer.parseInt(Sescolha);
                        switch (escolha) {
                            case 1:
                                double media = eventoController.calcularMediaAvaliacaoServico(EventoRepository.getAvaliacoesServico(), EventoRepository.getQuantAvServico());
                                if(media > 0){
                                    System.out.println("Média: " + media);
                                }else{
                                    System.out.println("Média não foi calculada");
                                    System.out.println("Nenhuma avaliação foi realizada para o serviço");
                                }
                                break;
                            case 2:
                                ranking = eventoController.calcularRankingHorarios(CinemaRepository.getHorarios(), CinemaRepository.getAvaliacoesHorarios(), CinemaRepository.getQuantAvHorarios());
                                for(int i=ranking.size()-1;i>=0;i--){
                                    System.out.println(i + " - " + ranking.get(i) + " Media: " + EventoRepository.getMedias().get(i));
                                }
                                break;
                            case 3:
                                ArrayList<Evento> eventos = new ArrayList<>();
                                for(Filme filme : CinemaRepository.getFilmesEmCartaz()){
                                    eventos.add((Evento) filme);
                                }
                                ranking = eventoController.calcularRanking(eventos);
                                for(int i=ranking.size()-1; i>=0;i--){
                                    System.out.println(ranking.size()-i + " - " + ranking.get(i) + ". Media " + EventoRepository.getMedias().get(i));
                                }
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (escolha < 0 || escolha > 3);
                    break;
                case 4: val = false;
                    break;
                default:
                    System.out.println("Seleção inválida!");
                    break;
            }
        }
    }

    private static void preencherCinema(EventoController cinema, AdministradorController admi){
        cinema.inserirADM( "Gabriel Lucas", "123456");
        cinema.inserirADM( "Acsa Laiane", "789456");
        cinema.inserirADM( "Gabriel Martins", "456789");
        cinema.inserirCliente( "Gabriel Lucas", "123456");
        cinema.inserirCliente( "Acsa Laiane", "789456");
        cinema.inserirCliente( "Gabriel Martins", "456789");
        admi.cadastrarEvento( "Harry Potter", 120, "Um menino mágico", "14",
                "Aventura", "01/10/2000");
        admi.cadastrarEvento( "Bob Esponja", 100, "Uma esponja que vive no fundo do mar", "Livre",
                "Aventura", "01/10/2000");
        admi.cadastrarEvento( "Narnia", 120, "Crianças brincando no guardarroupas", "14",
                "Fantasia", "01/10/2000");
        admi.cadastrarCupons( "marco20", 20.00);
        admi.cadastrarPremios( "Pipoca grátis", 76, 1);
    }
}