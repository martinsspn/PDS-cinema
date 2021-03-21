package PDSCinema.service;

import PDSCinema.Controller.CinemaController;
import PDSCinema.DAO.CinemaDAO;
import PDSCinema.DAO.CinemaDAOmemoria;
import PDSCinema.model.Administrador;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaService{
    private CinemaDAO cinemaDAO;

	public CinemaService() {
		this.cinemaDAO = new CinemaDAOmemoria();
	}

	@Override
	public int inserirCliente(CinemaRepository cinema, String cpf, String nome){
		try {
			if(nome != null && cpf != null) {
				if(!(cinema.getListaClientesCpf().contains(cpf))){
					cinemaDAO.inserirCliente(cinema, cpf, nome);
					return 0;
				}else{
					throw new Exception();
				}
			}else {
				throw new NumberFormatException();
			}
		}catch(NumberFormatException e) {
			System.out.println("Nome e/ou CPF não podem ser nulos.");
			return -1;
		}catch(Exception e){
			System.out.println("Cliente já está cadastrado!");
			return -2;
		}
	}
     @Override
    public int removerCliente(Cliente cliente, CinemaRepository cinema){
    	try {
     		if(cinema.getListaClientesCpf().contains(cliente.getCpf())) {
				cinemaDAO.removerCliente(cinema, cliente);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
    		System.out.println("ERRO: Cliente não existe na lista.");
     		return -1;
     	}
    }
    @Override
    public Cliente buscarCliente(CinemaRepository cinema, String cpf){
    	try {
      		if(cinema.getListaClientesCpf().contains(cpf)) {
      			return (cinemaDAO.buscarCliente(cinema, cpf));
      		}else {
      			throw new NumberFormatException();
      		}
      	}catch(NumberFormatException e) {
    		System.out.println("O Cliente não está cadastrado!");
      		return null;
      	}

    } 
    @Override
    public List <Cliente> buscarTodosCliente(CinemaRepository cinema){
		return cinemaDAO.buscarTodosCliente(cinema);
    }

    @Override
    public int inserirADM(CinemaRepository cinema, String nome, String cpf){
    	 try {
     		if(nome != null && cpf != null) {
     			if(!(cinema.getListaAdministradorCpf().contains(cpf))){
					cinemaDAO.inserirADM(cinema, nome, cpf);
					return 0;
				}else{
     				throw new Exception();
				}
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
    	 	System.out.println("Nome e/ou CPF não podem ser nulos.");
    	 	return -1;
     	}catch(Exception e){
    	 	System.out.println("ERRO: Administrador já está cadastrado!");
    	 	return -2;
		 }
    }
    @Override
    public int removerADM(Administrador ADM, CinemaRepository cinema){
    	try {
     		if(cinema.getListaAdministradorCpf().contains(ADM.getCpf())) {
				cinemaDAO.removerADM(cinema, ADM);
     			return 0;
     		}else {
     			throw new NumberFormatException();
     		}
     	}catch(NumberFormatException e) {
    		System.out.println("ERRO: Administrador não existe.");
     		return -1;
     	}
    }
     @Override
    public Administrador buscarADM(String cpf, CinemaRepository cinema){
    	try {
    		if(cinema.getListaAdministradorCpf().contains(cpf)){
       			return (cinemaDAO.buscarADM(cinema, cpf));
       		}else {
       			throw new NumberFormatException();
       		}
       	}catch(NumberFormatException e){
			System.out.println("ERRO: Administrador não existe.");
			return null;
       	}
    } 
    @Override
    public List <Administrador> buscarTodosADM(CinemaRepository cinema){
		return cinemaDAO.buscarTodosADM(cinema);
    }

    @Override
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
    	 return ((double)avaliacoesServico/(double)quantAvServico);

    }

	@Override
	public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz) {
		try{
			List<Double> valor = new ArrayList<>();
			for (Filme filme : filmesEmCartaz) {
				if(filme.getQuantAvaliacoes() == 0){
					valor.add(((double)(filme.getAvaliacoes())));
				}else{
					valor.add(((double)(filme.getAvaliacoes()) / (double)(filme.getQuantAvaliacoes())));
				}
			}
			return valor;
		}catch (ArithmeticException e){
			return null;
		}
	}


	@Override
    public List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
    	try{
    		List<Double> valor  = new ArrayList<>();
			for(int i=0; i < avaliacoesHorarios.size(); i++){
				if(quantAvHorarios.get(i) == 0){
					valor.add((double)(avaliacoesHorarios.get(i)));
				}else{
					valor.add((double)(avaliacoesHorarios.get(i)/quantAvHorarios.get(i)));
				}
			}
			return valor;
		}catch (ArithmeticException e){
    		return null;
		}
	}

	@Override
	public ArrayList<String> calcularRankingFilme(CinemaRepository cinemaRepository, List<Filme> filmesEmCartaz){
		List<Double> medias = calcularMediaAvaliacaoFilmes(filmesEmCartaz);
		ArrayList<String> rankingFilmes = new ArrayList<>();
		cinemaRepository.setMedias(medias);

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

	@Override
	public ArrayList<String> calcularRankingHorarios(CinemaRepository cinemaRepository, List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios) {
		List<Double> medias = calcularMediaAvaliacaoHorario(avaliacoesHorarios, quantAvHorarios);
		ArrayList<String> rankingHorarios = new ArrayList<>();
		cinemaRepository.setMedias(medias);

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
}
