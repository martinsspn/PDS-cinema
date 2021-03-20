package PDSCinema.View;

import PDSCinema.Controller.ClienteController;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.ClienteService;

import java.util.Scanner;

public class ClienteGUI {
    private CinemaRepository cinemaRepository;

    public ClienteGUI(CinemaRepository cinemaRepository, Cliente cliente){
        Scanner in = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ClienteController clienteController = new ClienteController(clienteService);
        this.cinemaRepository = cinemaRepository;
        System.out.println("Bem vindo ao cinema!!!");
        int op;
        int codigo;
        do{
            op = 10;
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Ver filmes em cartaz");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Resgatar Cupom");
            System.out.println("4 - Resgatar Premio");
            System.out.println("5 - Avaliar filme");
            System.out.println("6 - Avaliar serviço");
            System.out.println("7 - Avaliar Horário");
            System.out.println("8 - Compartilhar Cupom");
            System.out.println("9 - Sair");
            String Sop = in.nextLine();
            if(!Sop.isEmpty())
                op = Integer.parseInt(Sop);
            switch(op){
                case 1: codigo = 1;
                        for(Filme f: cinemaRepository.getFilmesEmCartaz()){
                            System.out.println("Filme: " + f.getName() + " Código" + codigo);
                            codigo++;
                        }
                        break;
                case 2: System.out.println("Digite o código do filme que você deseja comprar: ");
                        String Scodigo = in.nextLine();
                        codigo = Integer.parseInt(Scodigo);
                        int escolhaHorario = 10;
                        String horario = null;
                        boolean running = true;
                        do {
                            System.out.println("Horários disponíveis:");
                            System.out.println("1 - 12h30min");
                            System.out.println("2 - 13h00min");
                            System.out.println("3 - 13h30min");
                            System.out.println("4 - 14h00min");
                            System.out.println("5 - 14h30min");
                            System.out.println("6 - 15h30min");
                            System.out.println("7 - 17h00min");
                            System.out.println("8 - 18h30min");
                            System.out.println("9 - 20h00min");
                            System.out.println("Escolha o horário do filme:");
                            String SescolhaHorario = in.nextLine();
                            if(!SescolhaHorario.isEmpty())
                                escolhaHorario = Integer.parseInt(SescolhaHorario);
                            switch (escolhaHorario){
                                case 1: horario = "12h30min";
                                        running = false;
                                        break;
                                case 2: horario = "13h00min";
                                        running = false;
                                        break;
                                case 3: horario = "13h30min";
                                        running = false;
                                        break;
                                case 4: horario = "14h00min";
                                        running = false;
                                        break;
                                case 5: horario = "14h30min";
                                        running = false;
                                        break;
                                case 6: horario = "15h30min";
                                        running = false;
                                        break;
                                case 7: horario = "17h00min";
                                        running = false;
                                        break;
                                case 8: horario = "18h30min";
                                        running = false;
                                        break;
                                case 9: horario = "20h00min";
                                        running = false;
                                        break;
                                default: System.out.println("Opção inválida!");
                            }
                        }while(running);
                        System.out.println("Deseja adicionar cupom?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        String Sdcup = in.nextLine();
                        int dcup = 0;
                        if(!Sdcup.isEmpty())
                            dcup = Integer.parseInt(Sdcup);
                        Ingresso ingresso = new Ingresso();
                        ingresso.setHorario(horario);
                        ingresso.setFilme(cinemaRepository.getFilmesEmCartaz().get(codigo-1));
                        ingresso.setSala(1);
                        ingresso.setPreco(25);
                        if(dcup == 1){
                                System.out.println("Digite o código do cupom:");
                                String codigoCup = in.nextLine();
                                String status = clienteController.resgatarCupom(cinemaRepository, cliente, codigoCup);
                                System.out.println(status);
                                if(status.equals("Cupom resgatado com sucesso")){
                                    System.out.println("Preço do ingresso: R$" + (25-cliente.getCuponsAtivos().get(codigo).getTipoDeCupom()));
                                    System.out.println("Digite o valor do pagamento:");
                                    String Spagamento = in.nextLine();
                                    double pagamento = 0;
                                    if(!Spagamento.isEmpty())
                                        pagamento = Double.parseDouble(Spagamento);
                                    status = clienteController.comprarIngresso(ingresso, pagamento, cliente.getCuponsAtivos().get(cliente.getCuponsAtivos().size()-1));
                                    System.out.println(status);
                                }
                            }else{
                                System.out.println("Preço do ingresso: R$" + 25);
                                System.out.println("Digite o valor do pagamento:");
                                String Spagamento = in.nextLine();
                                double pagamento = 0;
                                if(!Spagamento.isEmpty())
                                    pagamento = Double.parseDouble(Spagamento);
                                String status = clienteController.comprarIngresso(ingresso, pagamento);
                                System.out.println(status);
                            }
                case 9: break;
                default: System.out.println("opção inválida");
            }
        }while(op != 9);
    }
}
