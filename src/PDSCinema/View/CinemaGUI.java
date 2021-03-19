package PDSCinema.View;

import PDSCinema.Controller.CinemaController;
import PDSCinema.model.Administrador;
import PDSCinema.repository.CinemaRepository;

import java.util.Scanner;

public class CinemaGUI {
    CinemaGUI() {
        CinemaController cinema = new CinemaController();
        CinemaRepository cinemaRepo = new CinemaRepository();
        boolean running = true;
        boolean val = true;
        while (running) {
            while (val) {
                System.out.println("Tipo de usuário: ");
                System.out.println("1 - Administrador");
                System.out.println("2 - Cliente");
                Scanner in = new Scanner(System.in);
                int sel = in.nextInt();
                switch (sel) {
                    case 1:
                        if(cinema.buscarTodosADM().isEmpty()){
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
                            if(status.equals("Erro ao cadastrar o administrador!")){
                                while(status.equals("Erro ao cadastrar o administrador!")) {
                                    System.out.println("Tente novamente");
                                    System.out.print("Nome: ");
                                    nome = in.nextLine();
                                    System.out.print("CPF: ");
                                    CPF = in.nextLine();
                                    status = cinema.inserirADM(cinemaRepo, nome, CPF);
                                    System.out.println(status);
                                }
                            }
                        }else{
                            Administrador adm;
                            String CPF;
                            System.out.println("Digite seu CPF");
                            CPF = in.nextLine();
                            adm = cinema.buscarADM(CPF, cinemaRepo);
                            if(adm == null){
                                boolean val3 = true;
                                while(val3){
                                    System.out.println("CPF inválido ou não cadastrado.");
                                    System.out.println("1 - Tentar novamente");
                                    System.out.println("2 - Cadastrar-se");
                                    int sel2 = in.nextInt();
                                    switch (sel2) {
                                        case 1 -> {
                                            boolean trying = true;
                                            while (adm == null && trying) {
                                                System.out.println("Digite seu CPF: ");
                                                CPF = in.nextLine();
                                                adm = cinema.buscarADM(CPF, cinemaRepo);
                                                if (adm == null) {
                                                    System.out.println("Deseja desistir? 0 - não 1 - sim");
                                                    int input = in.nextInt();
                                                    if (input == 1) {
                                                        trying = false;
                                                    }
                                                }
                                            }
                                            val3 = false;
                                        }
                                        case 2 -> {
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
                                        }
                                        default -> System.out.println("Seleção inválida");
                                    }
                                }
                            }
                        }
                        //interace adm
                        val = false;
                        break;
                    case 2:
                        //interface cliente
                        val = false;
                        break;
                    default:
                        System.out.println("Seleção inválida!");
                        break;
                }
            }
        }
    }
}