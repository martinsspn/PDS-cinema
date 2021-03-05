package PDSCinema.service;

import PDSCinema.DAO.CinemaDAO;
import PDSCinema.DAO.CinemaDAOmemoria;
import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaService{
    private Cinema cinema;
	private CinemaDAO cinemaDAO;

	public CinemaService() {
		this.cinema = new Cinema();
		this.cinemaDAO = new CinemaDAOmemoria();
	}

	@Override
	public int inserirCliente(String cpf, String nome){
		try {
			if(nome != null && !(cinema.getListaClientesCpf().contains(cpf))) {
				cinemaDAO.inserirCliente(cinema, cpf, nome);
				return 0;
			}else {
				throw new NumberFormatException();
			}
		}catch(NumberFormatException e) {
			return -1;
		}
	}
     @Override
    public int removerCliente(Cliente cliente, Cinema cinema){
    	try {
     		if(cinema.getListaClientesCpf().contains(cliente.getCpf())) {
				cinemaDAO.removerCliente(cliente, cinema);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
     		return -1;
     	}
    }
    @Override
    public ClienteService buscarCliente(String cpf, Cinema cinema){
    	try {
      		if(cinema.getListaClientesCpf().contains(cpf)) {
      			return (cinemaDAO.buscarCliente(cpf, cinema));
      		}else {
      			throw new NumberFormatException();
      		}
      	}catch(NumberFormatException e) {
      		return null;
      	}

    } 
    @Override
    public List <ClienteService> buscarTodosCliente(){
		return cinemaDAO.buscarTodosCliente(cinema);
    }

    @Override
    public int inserirADM(Cinema cinema, String nome, String cpf){
    	 try {
     		if(nome != null && !(cinema.getListaAdministradorCpf().contains(cpf))) {
				cinemaDAO.inserirADM(cinema, nome, cpf);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
     		return -1;
     	}
    }
    @Override
    public int removerADM(Administrador ADM, Cinema cinema){
    	try {
     		if(cinema.getListaAdministradorCpf().contains(ADM.getCpf())) {
				cinemaDAO.removerADM(ADM, cinema);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
     		return -1;
     	}
    }
     @Override
    public Administrador buscarADM(String cpf, Cinema cinema){
    	try {
    		if(cinema.getListaAdministradorCpf().contains(cpf)){
       			return (cinemaDAO.buscarADM(cpf, cinema));
       		}else {
       			throw new NumberFormatException();
       		}
       	}catch(NumberFormatException e){
       		return null;
       	}
    } 
    @Override
    public List <Administrador> buscarTodosADM(){
		return cinemaDAO.buscarTodosADM(cinema);
    }

    @Override
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
    	 return ((double)avaliacoesServico/(double)quantAvServico);

    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz){
    	List<Double> valor = new ArrayList<>();
		for (Filme filme : filmesEmCartaz) {
			valor.add(((double)(filme.getAvaliacoes()) / (double)(filme.getQuantAvaliacoes())));
		}
    	return valor;
    }
    public List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
    	List<Double> valor  = new ArrayList<>();
    	for(int i=0; i < avaliacoesHorarios.size(); i++){
    		valor.add((double)(avaliacoesHorarios.get(i)/quantAvHorarios.get(i)));
    	}
    	return valor;
    }
	public Cinema getCinema() {
		return cinema;
	}

	public ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
		List<Double> medias = calcularMediaAvaliacaoHorario(avaliacoesHorarios, quantAvHorarios);
		ArrayList<String> rankingHorarios = new ArrayList<>();

		for(String horario : horarios)
			rankingHorarios.add(horario);

		int i, j, min;
		Double aux;
		String aux2;
		for (i = 0; i < (horarios.size())-1; i++){
			min = i;
			for (j = (i + 1); j < horarios.size(); j++) {
				if (medias.get(j) < medias.get(min))
					min = j;
			}
			if (i != min) {
				aux = medias.get(i);
				aux2 = rankingHorarios.get(i);
				medias.set(i, medias.get(min));
				medias.set(min, aux);
				rankingHorarios.set(i, rankingHorarios.get(min));
				rankingHorarios.set(min, aux2);
			}
		}
		return rankingHorarios;
	}

	public ArrayList<String> calcularRankingFilme(List<Filme> filmesEmCartaz){
		List<Double> medias = calcularMediaAvaliacaoFilmes(filmesEmCartaz);
		ArrayList<String> rankingFilmes = new ArrayList<>();

		for(Filme filme : filmesEmCartaz)
			rankingFilmes.add(filme.getName());

		int i, j, min;
		Double aux;
		String aux2;
		for (i = 0; i < (filmesEmCartaz.size())-1; i++){
			min = i;
			for (j = (i + 1); j < filmesEmCartaz.size(); j++) {
				if (medias.get(j) < medias.get(min))
					min = j;
			}
			if (i != min) {
				aux = medias.get(i);
				aux2 = rankingFilmes.get(i);
				medias.set(i, medias.get(min));
				medias.set(min, aux);
				rankingFilmes.set(i, rankingFilmes.get(min));
				rankingFilmes.set(min, aux2);
			}
		}
		return rankingFilmes;
	}
}
