package PDSCinema.Controller;

import PDSCinema.model.*;
import PDSCinema.service.ClientePolimorfismo.InserirAvaliacaoEvento;
import PDSCinema.service.ClienteService;
import PDSCinema.service.ClienteStrategy.ClienteCinema;

public class ClienteController {

    private final ClienteService cliente;
    public ClienteController(ClienteService cliente){
        this.cliente = cliente;
    }
    public String avaliarServico(int avaliacao){
        int status = cliente.inserirAvaliacaoServico(avaliacao);
        if(status == 0){
            return ("Avaliação cadastrada");
        }else{
            return ("Avaliação inválida!");
        }
    }
    public String avaliarHorario(String horario ,int avaliacao){
        int status = cliente.inseriAvaliacaoHorario(horario, avaliacao);
        if(status == 0){
            return ("Avaliação cadastrada");
        }else{
            return ("Avaliação inválida!");
        }
    }
    public String resgatarCupom(Cliente cliente, String codigo){
        int status = this.cliente.resgatarCupom(cliente, codigo);
        if(status == 0){
            return ("Cupom resgatado com sucesso");
        }else{
            return ("Cupom inválido!");
        }
    }
    public String resgatarPremio(Cliente cliente, int codigo){
        String status = this.cliente.resgatarPremio(cliente, codigo);
        if(status == "-1" || status == "-2"){
            return ("Premio inválido!");
        }else{
            return "- " + status;
        }
    }
    public String avaliarEvento(Evento evento, int avaliacao){
        int status = cliente.getInserirAvaliacaoEvento().inserirAvaliacaoEvento(evento, avaliacao);
        if(status == 0){
            return ("Avaliação cadastrada com sucesso");
        }else {
            return ("Avaliação inválida!");
        }
    }


    public String comprarIngresso(Ingresso ingresso, Cliente cliente,double pagamento){
        double status = this.cliente.comprarIngresso(ingresso, cliente, pagamento);
        if(status >= 0){
            return ("Ingresso comprado com sucesso\nTroco: "+ status);
        }else{
            return ("Falha ao comprar ingresso!");
        }
    }
    public String comprarIngresso(Ingresso ingresso, Cliente cliente,double pagamento, Cupom cupom){
        double status = this.cliente.comprarIngresso(ingresso, cliente,pagamento, cupom);
        if(status >= 0){
            return ("Ingresso comprado com sucesso\nTroco: " + status);
        }else{
            return ("Falha ao comprar ingresso!");
        }
    }
    public void compartilharCupom(Cliente cliente){
        String cupom = this.cliente.compartilharCupom(cliente);
        System.out.println(cupom);
    }
}
