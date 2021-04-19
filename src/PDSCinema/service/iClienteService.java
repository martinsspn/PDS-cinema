package PDSCinema.service;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

public interface iClienteService {

    double comprarIngresso(Ingresso ingresso, Cliente cliente, double pagamento, Cupom cupom);

    double comprarIngresso(Ingresso ingresso, Cliente cliente, double pagamento);

    int inserirAvaliacaoServico(int avaliacao);

    int inseriAvaliacaoHorario(String horario, int avaliacao);

    int resgatarCupom(Cliente cliente, String codigo);

    String resgatarPremio(Cliente cliente, int codigo);

    String compartilharCupom(Cliente cliente);
}
