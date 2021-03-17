package PDSCinema.service;



import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import PDSCinema.repository.CinemaRepository;

public interface iClienteService {
    int avaliarServico(CinemaRepository cinema, int avaliacao);
    int avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao);
    int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo);
    int resgatarPremio(CinemaRepository cinema, Cliente cliente, int codigo);
    int avaliarFilme(Filme filme, int avaliacao);
    int comprarIngresso(Ingresso ingresso, int pagamento);
    int comprarIngresso(Ingresso ingresso, int pagamento, Cupom cupom);
    String compartilharCupom(Cliente cliente);
}
