package PDSCinema.service;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

public interface iClienteService {

    double comprarIngresso(Ingresso ingresso, Cliente cliente, double pagamento, Cupom cupom);

    double comprarIngresso(Ingresso ingresso, Cliente cliente, double pagamento);

    int avaliarEvento(Evento evento, int avaliacao);

    int avaliarServico(int avaliacao);

    int resgatarCupom(Cliente cliente, String codigo);

    String resgatarPremio(Cliente cliente, int codigo);

    String compartilharCupom(Cliente cliente);
}
