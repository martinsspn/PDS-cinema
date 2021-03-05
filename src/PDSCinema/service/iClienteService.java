package PDSCinema.service;


import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;

public interface iClienteService {
    int avaliarServico(Cinema cinema, int avaliacao);
    int avaliarHorario(Cinema cinema, String horario ,int avaliacao);
    int utilizarCupom();
	int compartilharCupom();
    int resgatarPremio();
	int avaliarFilme(Filme filme, int avaliacao);
	int comprarIngresso(Ingresso ingresso, int pagamento);
    Cliente getCliente();
}
