package PDSCinema.Controller;

import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.ClienteService;

public class ClienteController {
    private final ClienteService cliente;
    ClienteController(ClienteService cliente){
        this.cliente = cliente;
    }
    public int avaliarServico(CinemaRepository cinema, int avaliacao){
        int status = cliente.avaliarServico(cinema, avaliacao);
        if(status == 0){
            System.out.println("Avaliação cadastrada");
            return 0;
        }else{
            System.out.println("Avaliação inválida!");
            return -1;
        }
    }
    public int avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao){
        int status = cliente.avaliarHorario(cinema, horario, avaliacao);
        if(status == 0){
            System.out.println("Avaliação cadastrada");
            return 0;
        }else{
            System.out.println("Avaliação inválida!");
            return -1;
        }
    }
    public int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo){
        int status = this.cliente.resgatarCupom(cinema, cliente, codigo);
        if(status == 0){
            System.out.println("Cupom resgatado com sucesso");
            return 0;
        }else{
            System.out.println("Cupom inválido!");
            return -1;
        }
    }
    public int resgatarPremio(CinemaRepository cinema, Cliente cliente, int codigo){
        int status = this.cliente.resgatarPremio(cinema, cliente, codigo);
        if(status == 0){
            System.out.println("Premio resgatado com sucesso");
            return 0;
        }else{
            System.out.println("Premio inválido!");
            return -1;
        }
    }
    public int avaliarFilme(Filme filme, int avaliacao){
        int status = cliente.avaliarFilme(filme, avaliacao);
        if(status == 0){
            System.out.println("Avaliação cadastrada com sucesso");
            return 0;
        }else {
            System.out.println("Avaliação inválida!");
            return -1;
        }
    }
    public int comprarIngresso(Ingresso ingresso, int pagamento){
        int status = cliente.comprarIngresso(ingresso, pagamento);
        if(status == 0){
            System.out.println("Ingresso comprado com sucesso");
            return 0;
        }else{
            System.out.println("Falha ao comprar ingresso!");
            return -1;
        }
    }
    public int comprarIngresso(Ingresso ingresso, int pagamento, Cupom cupom){
        int status = cliente.comprarIngresso(ingresso, pagamento, cupom);
        if(status == 0){
            System.out.println("Ingresso comprado com sucesso");
            return 0;
        }else{
            System.out.println("Falha ao comprar ingresso!");
            return -1;
        }
    }
    public void compartilharCupom(Cliente cliente){
        String cupom = this.cliente.compartilharCupom(cliente);
        System.out.println(cupom);
    }
}
