package PDSCinema.View;

import PDSCinema.Controller.ClienteController;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.ClienteService;

import java.util.Scanner;

public class ClienteGUI {

    public ClienteGUI(Cliente cliente){
        Scanner in = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ClienteController clienteController = new ClienteController(clienteService);
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
                        if(CinemaRepository.getFilmesEmCartaz().size()>0){
                            System.out.println("Filmes em cartaz:");
                            for(Filme f: CinemaRepository.getFilmesEmCartaz()){
                                System.out.println("- " + f.getName() + ". Código: " + codigo);
                                codigo++;
                            }
                        }else{
                            System.out.println("Não há nenhum filme em cartaz no momento.");
                        }
                        break;
                case 2: System.out.println("Digite o código do filme que você deseja comprar: ");
                        String Scodigo = in.nextLine();
                        codigo = Integer.parseInt(Scodigo);
                        if(codigo < 0 || codigo > CinemaRepository.getFilmesEmCartaz().size()){
                            System.out.println("Filme não encontrado!");
                            break;
                        }
                        int escolhaHorario = 10;
                        String horario = null;
                        boolean running = true;
                        do {
                            System.out.println("Horários disponíveis:");
                            CinemaRepository.setHorarios();
                            for(int i=0;i<CinemaRepository.getHorarios().size();i++){
                                System.out.println((i+1) + " - " +CinemaRepository.getHorarios().get(i));
                            }
                            System.out.println("Escolha o horário do filme:");
                            String SescolhaHorario = in.nextLine();
                            if(!SescolhaHorario.isEmpty())
                                escolhaHorario = Integer.parseInt(SescolhaHorario);
                            if(escolhaHorario < 0 || escolhaHorario >= CinemaRepository.getHorarios().size()){
                                System.out.println("Opção inválida");
                            }else{
                                horario = CinemaRepository.getHorarios().get(escolhaHorario-1);
                                running = false;
                            }
                        }while(running);
                        int dcup = 0;
                        do{
                            System.out.println("Deseja adicionar cupom?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            String Sdcup = in.nextLine();
                            if(!Sdcup.isEmpty())
                                dcup = Integer.parseInt(Sdcup);
                            switch (dcup){
                                case 1: break;
                                case 2: break;
                                default: System.out.println("Opção inválida");
                            }
                        }while(dcup != 1 && dcup != 2);
                        IngressoCinema ingresso = new IngressoCinema();
                        ingresso.setHorario(horario);
                        ingresso.setFilme(CinemaRepository.getFilmesEmCartaz().get(codigo-1));
                        ingresso.setSala(1);
                        ingresso.setPreco(25);
                        if(dcup == 1){
                            int opcao = 0;
                            do{
                                System.out.println("Deseja adicionar um cupom novo ou utilizar um cupom já resgatado?");
                                System.out.println("1 - adicionar novo");
                                System.out.println("2 - utilizar cupom já resgatado");
                                String codigoCup = in.nextLine();
                                if(!codigoCup.isEmpty())
                                    opcao = Integer.parseInt(codigoCup);
                                if(cliente.getCuponsAtivos().size() != 0 || opcao == 1){
                                    switch (opcao){
                                        case 1:
                                            System.out.println("Digite o código do cupom:");
                                            codigoCup = in.nextLine();
                                            String status = clienteController.resgatarCupom(cliente, codigoCup);
                                            System.out.println(status);
                                            if(status.equals("Cupom resgatado com sucesso")){
                                                System.out.println("Preço do ingresso: R$" + (25-cliente.getCuponsAtivos().get(cliente.getCuponsAtivos().size()-1).getTipoDeCupom()));
                                                System.out.println("Digite o valor do pagamento:");
                                                String Spagamento = in.nextLine();
                                                double pagamento = 0;
                                                if(!Spagamento.isEmpty())
                                                    pagamento = Double.parseDouble(Spagamento);
                                                status = clienteController.comprarIngresso(ingresso, cliente, pagamento, cliente.getCuponsAtivos().get(cliente.getCuponsAtivos().size()-1));
                                                System.out.println(status);
                                            }
                                            break;
                                        case 2:
                                            int x = 0;
                                            for(Cupom c: cliente.getCuponsAtivos()){
                                                System.out.println(c.getCodigo() + " Código de ativação: " + x);
                                                x++;
                                            }
                                            do{
                                                dcup = -1;
                                                System.out.println("Digite o código de ativação:");
                                                codigoCup = in.nextLine();
                                                if(!codigoCup.isEmpty())
                                                    dcup = Integer.parseInt(codigoCup);
                                                if(dcup >= 0 && dcup < cliente.getCuponsAtivos().size()){
                                                    break;
                                                }
                                            }while(true);
                                            System.out.println("Preço do ingresso: R$" + (25-cliente.getCuponsAtivos().get(dcup).getTipoDeCupom()));
                                            System.out.println("Digite o valor do pagamento:");
                                            String Spagamento = in.nextLine();
                                            double pagamento = 0;
                                            if(!Spagamento.isEmpty())
                                                pagamento = Double.parseDouble(Spagamento);
                                            status = clienteController.comprarIngresso(ingresso, cliente, pagamento, cliente.getCuponsAtivos().get(dcup));
                                            System.out.println(status);
                                    }
                                }else{
                                    System.out.println("Cliente não possui cupons cadastrados");
                                }
                            }while(opcao != 1 && opcao != 2);

                            }else{
                                System.out.println("Preço do ingresso: R$" + 25);
                                System.out.println("Digite o valor do pagamento:");
                                String Spagamento = in.nextLine();
                                double pagamento = 0;
                                if(!Spagamento.isEmpty())
                                    pagamento = Double.parseDouble(Spagamento);
                                String status = clienteController.comprarIngresso(ingresso, cliente,pagamento);
                                System.out.println(status);
                            }
                        break;
                case 3:
                    System.out.println("Digite o código do cupom:");
                    String codigoCup = in.nextLine();
                    String status = clienteController.resgatarCupom(cliente, codigoCup);
                    System.out.println(status);
                    break;
                case 4: System.out.println("Prêmios resgatados:");
                        for(Premio p: cliente.getPremios())
                            clienteController.resgatarPremio(cliente, p.getIdPremio());
                        break;
                case 5: System.out.println("Digite o código do filme:");
                        int codigoFilme = -1;
                        String ScodigoFilme = in.nextLine();
                        if(!ScodigoFilme.isEmpty())
                            codigoFilme = Integer.parseInt(ScodigoFilme);
                        if(codigoFilme < 0 || codigoFilme-1 >= CinemaRepository.getFilmesEmCartaz().size()){
                            System.out.println("Código digitado não possui filme cadastrado");
                        }else{
                            System.out.println("Digite a sua avaliação de 0 a 5:");
                            int avaliacao =-1;
                            ScodigoFilme = in.nextLine();
                            if(!ScodigoFilme.isEmpty())
                                avaliacao = Integer.parseInt(ScodigoFilme);
                            status = clienteController.avaliarEvento(CinemaRepository.getFilmesEmCartaz().get(codigoFilme-1), avaliacao);
                            System.out.println(status);
                        }
                        break;
                case 6: System.out.println("Digite a avaliação do serviço de 0 a 5:");
                        String SavServico = in.nextLine();
                        int avSercivo = -1;
                        if(!SavServico.isEmpty())
                            avSercivo = Integer.parseInt(SavServico);
                        status = clienteController.avaliarServico(avSercivo);
                        System.out.println(status);
                        break;
                case 7: System.out.println("Horários disponíveis para avaliar:");
                    for(int i=0;i<CinemaRepository.getHorarios().size();i++){
                        System.out.println((i+1) + " - " +CinemaRepository.getHorarios().get(i));
                    }
                    System.out.println("Escolha o horário que deseja avaliar:");
                    String SescolhaHorario = in.nextLine();
                    escolhaHorario = -1;
                    if(!SescolhaHorario.isEmpty())
                        escolhaHorario = Integer.parseInt(SescolhaHorario);
                    if(escolhaHorario < 0 || escolhaHorario >= CinemaRepository.getHorarios().size()){
                        System.out.println("Opção inválida");
                    }else{
                        horario = CinemaRepository.getHorarios().get(escolhaHorario-1);
                        System.out.println("Digite sua avaliação de 0 a 5:");
                        String Savaliacao = in.nextLine();
                        int avaliacao = -1;
                        if(!Savaliacao.isEmpty())
                            avaliacao = Integer.parseInt(Savaliacao);
                        status = clienteController.avaliarHorario(horario, avaliacao);
                        System.out.println(status);
                    }
                    break;
                case 8: clienteController.compartilharCupom(cliente);
                case 9: break;
                default: System.out.println("opção inválida");
            }
        }while(op != 9);
    }
}
