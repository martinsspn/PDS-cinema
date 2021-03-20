package PDSCinema.View;

import PDSCinema.Controller.AdministradorController;
import PDSCinema.Controller.CinemaController;
import PDSCinema.model.Administrador;
import PDSCinema.model.Cliente;
import PDSCinema.repository.CinemaRepository;

import java.util.List;
import java.util.Scanner;

public class CinemaGUI {
    public CinemaGUI() {
        CinemaController cinema = new CinemaController();
        CinemaRepository cinemaRepo = new CinemaRepository();
        AdministradorController admi = new AdministradorController();
        cinema.inserirADM(cinemaRepo, "Gabriel Lucas", "123456");
        cinema.inserirADM(cinemaRepo, "Acsa Laiane", "789456");
        cinema.inserirADM(cinemaRepo, "Gabriel Martins", "456789");
        cinema.inserirCliente(cinemaRepo, "Gabriel Lucas", "123456");
        cinema.inserirCliente(cinemaRepo, "Acsa Laiane", "789456");
        cinema.inserirCliente(cinemaRepo, "Gabriel Martins", "456789");
        admi.cadastrarFilmes(cinemaRepo, "Harry Potter", 120, "Um menino mágico", "14",
                "Aventura", "01/10/2000");
        admi.cadastrarFilmes(cinemaRepo, "Bob Esponja", 100, "Uma esponja que vive no fundo do mar", "Livre",
                "Aventura", "01/10/2000");
        admi.cadastrarFilmes(cinemaRepo, "Narnia", 120, "Crianças brincando no guardarroupas", "14",
                "Fantasia", "01/10/2000");
        admi.cadastrarCupons(cinemaRepo, "marco20", 20.00);
        admi.cadastrarPremios(cinemaRepo, "Pipoca grátis", 76, 1);
        boolean running = true;
        boolean val = true;
        Cliente cliente = new Cliente();
        while (val) {
            while (val) {
                System.out.println("Bem vindo ao cinema!");
                System.out.println("Escolha a opção:");
                System.out.println("1 - Entrar como administrador");
                System.out.println("2 - Entrar como cliente");
                System.out.println("3 - Ver ranking");
                System.out.println("4 - Sair");

                Scanner in = new Scanner(System.in);
                String sel = in.nextLine();
                switch (Integer.parseInt(sel)) {
                    case 1:
                        if (cinema.buscarTodosADM(cinemaRepo).isEmpty()) {
                            System.out.println("Não há nenhum administrador cadastrado!");
                            System.out.println("Por favor, cadastre-se");
                            String nome;
                            String CPF;
                            System.out.print("Nome: ");
                            nome = in.nextLine();
                            System.out.print("CPF: ");
                            CPF = in.nextLine();
                            String status = cinema.inserirADM(cinemaRepo, nome, CPF);
                            System.out.println(status);
                            if (status.equals("Erro ao cadastrar o administrador!")) {
                                while (status.equals("Erro ao cadastrar o administrador!")) {
                                    System.out.println("Tente novamente");
                                    System.out.print("Nome: ");
                                    nome = in.nextLine();
                                    System.out.print("CPF: ");
                                    CPF = in.nextLine();
                                    status = cinema.inserirADM(cinemaRepo, nome, CPF);
                                    System.out.println(status);
                                }
                            }
                        } else {
                            Administrador adm;
                            String CPF;
                            System.out.println("Digite seu CPF");
                            CPF = in.nextLine();
                            adm = cinema.buscarADM(CPF, cinemaRepo);
                            if (adm == null) {
                                boolean val3 = true;
                                while (val3) {
                                    System.out.println("CPF inválido ou não cadastrado.");
                                    System.out.println("1 - Tentar novamente");
                                    System.out.println("2 - Cadastrar-se");
                                    int sel2 = in.nextInt();
                                    switch (sel2) {
                                        case 1:
                                            boolean trying = true;
                                            while (adm == null && trying) {
                                                System.out.println("Digite seu CPF: ");
                                                CPF = in.nextLine();
                                                adm = cinema.buscarADM(CPF, cinemaRepo);
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
                                            String status = cinema.inserirADM(cinemaRepo, CPF, nome);
                                            System.out.println(status);
                                            while (status.equals("Erro ao cadastrar o administrador!")) {
                                                System.out.println("Tente novamente");
                                                System.out.print("Nome: ");
                                                nome = in.nextLine();
                                                System.out.print("CPF: ");
                                                CPF = in.nextLine();
                                                status = cinema.inserirADM(cinemaRepo, nome, CPF);
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
                        AdministradorGUI administradorGUI = new AdministradorGUI(cinemaRepo);
                        val = true;
                        break;
                    case 2:
                        if (cinema.buscarTodosCliente(cinemaRepo).isEmpty()) {
                            System.out.println("Não há nenhum cliente cadastrado!");
                            System.out.println("Por favor, cadastre-se");
                            String nome;
                            String CPF;
                            System.out.print("Nome: ");
                            nome = in.nextLine();
                            System.out.print("CPF: ");
                            CPF = in.nextLine();
                            String status = cinema.inserirCliente(cinemaRepo, CPF, nome);
                            System.out.println(status);
                            if (status.equals("Erro ao cadastrar o cliente!")) {
                                while (status.equals("Erro ao cadastrar o cliente!")) {
                                    System.out.println("Tente novamente");
                                    System.out.print("Nome: ");
                                    nome = in.nextLine();
                                    System.out.print("CPF: ");
                                    CPF = in.nextLine();
                                    status = cinema.inserirCliente(cinemaRepo, CPF, nome);
                                    System.out.println(status);
                                }
                            }
                            cliente = cinema.buscarCliente(cinemaRepo, CPF);
                        } else {
                            String CPF;
                            System.out.println("Digite seu CPF");
                            CPF = in.nextLine();
                            cliente = cinema.buscarCliente(cinemaRepo, CPF);
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
                                                cliente = cinema.buscarCliente(cinemaRepo, CPF);
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
                                            String status = cinema.inserirCliente(cinemaRepo, CPF, nome);
                                            System.out.println(status);
                                            while (status.equals("Erro ao cadastrar o cliente!")) {
                                                System.out.println("Tente novamente");
                                                System.out.print("Nome: ");
                                                nome = in.nextLine();
                                                System.out.print("CPF: ");
                                                CPF = in.nextLine();
                                                status = cinema.inserirCliente(cinemaRepo, CPF, nome);
                                                System.out.println(status);
                                            }
                                            cliente = cinema.buscarCliente(cinemaRepo, CPF);
                                            val3 = false;
                                            break;
                                        default:
                                            System.out.println("Seleção inválida");
                                    }
                                }
                            }
                        }
                        ClienteGUI clienteGUI = new ClienteGUI(cinemaRepo, cliente);
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
                                    cinema.calcularMediaAvaliacaoServico(cinemaRepo.getAvaliacoesServico(), cinemaRepo.getQuantAvServico());
                                    break;
                                case 2:
                                    ranking = cinema.calcularRankingHorarios(cinemaRepo.getHorarios(), cinemaRepo.getAvaliacoesHorarios(), cinemaRepo.getQuantAvHorarios());
                                    for (String s : ranking) {
                                        System.out.println(s);
                                    }
                                    break;
                                case 3:
                                    ranking = cinema.calcularRankingFilme(cinemaRepo.getFilmesEmCartaz());
                                    for (String s : ranking) {
                                        System.out.println(s);
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
    }
}