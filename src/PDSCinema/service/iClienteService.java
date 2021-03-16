package PDSCinema.service;



import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import PDSCinema.repository.CinemaRepository;

public interface iClienteService {
    int avaliarServico(CinemaRepository cinema, int avaliacao);
    int avaliarHorario(CinemaRepository cinema, String horario ,int avaliacao);
    int utilizarCupom();
	int compartilharCupom();
    int resgatarPremio();
	int avaliarFilme(Filme filme, int avaliacao);
	int comprarIngresso(Ingresso ingresso, int pagamento);
    Cliente getCliente();
}
