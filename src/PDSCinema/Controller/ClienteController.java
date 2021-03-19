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
    public String avaliarServico(CinemaRepository cinema, int avaliacao){
        int status = cliente.avaliarServico(cinema, avaliacao);
        if(status == 0){
            return ("Avaliação cadastrada");
        }else{
            return ("Avaliação inválida!");
        }
    }
    public String avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao){
        int status = cliente.avaliarHorario(cinema, horario, avaliacao);
        if(status == 0){
            return ("Avaliação cadastrada");
        }else{
            return ("Avaliação inválida!");
        }
    }
    public String resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo){
        int status = this.cliente.resgatarCupom(cinema, cliente, codigo);
        if(status == 0){
            return ("Cupom resgatado com sucesso");
        }else{
            return ("Cupom inválido!");
        }
    }
    public String resgatarPremio(CinemaRepository cinema, Cliente cliente, int codigo){
        int status = this.cliente.resgatarPremio(cinema, cliente, codigo);
        if(status == 0){
            return ("Premio resgatado com sucesso");
        }else{
            return ("Premio inválido!");
        }
    }
    public String avaliarFilme(Filme filme, int avaliacao){
        int status = cliente.avaliarFilme(filme, avaliacao);
        if(status == 0){
            return ("Avaliação cadastrada com sucesso");
        }else {
            return ("Avaliação inválida!");
        }
    }
    public String comprarIngresso(Ingresso ingresso, int pagamento){
        int status = cliente.comprarIngresso(ingresso, pagamento);
        if(status == 0){
            return ("Ingresso comprado com sucesso");
        }else{
            return ("Falha ao comprar ingresso!");
        }
    }
    public String comprarIngresso(Ingresso ingresso, int pagamento, Cupom cupom){
        int status = cliente.comprarIngresso(ingresso, pagamento, cupom);
        if(status == 0){
            return ("Ingresso comprado com sucesso");
        }else{
            return ("Falha ao comprar ingresso!");
        }
    }
    public void compartilharCupom(Cliente cliente){
        String cupom = this.cliente.compartilharCupom(cliente);
        System.out.println(cupom);
    }
}
