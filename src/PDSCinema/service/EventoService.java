package PDSCinema.service;

import PDSCinema.DAO.EventoDAO;
import PDSCinema.DAO.EventoDAOmemoria;
import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Administrador;
import PDSCinema.repository.AdministradorRepository;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.repository.ClienteRepository;
import PDSCinema.repository.EventoRepository;

import java.util.ArrayList;
import java.util.List;

public class EventoService implements iEventoService {
    private EventoDAO eventoDAO = SingletonEventoDAO.getEvento();

	@Override
	public int inserirCliente(String cpf, String nome){
		try {
			if(nome != null && cpf != null) {
				if(!(ClienteRepository.getListaClientesCpf().contains(cpf))){
					eventoDAO.inserirCliente(cpf, nome);
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
    public int removerCliente(Cliente cliente){
    	try {
     		if(ClienteRepository.getListaClientesCpf().contains(cliente.getCpf())) {
				eventoDAO.removerCliente(cliente);
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
    public Cliente buscarCliente(String cpf){
    	try {
      		if(ClienteRepository.getListaClientesCpf().contains(cpf)) {
      			return (eventoDAO.buscarCliente(cpf));
      		}else {
      			throw new NumberFormatException();
      		}
      	}catch(NumberFormatException e) {
    		System.out.println("O Cliente não está cadastrado!");
      		return null;
      	}

    } 
    @Override
    public List <Cliente> buscarTodosCliente(){
		return eventoDAO.buscarTodosCliente();
    }

    @Override
    public int inserirADM(String nome, String cpf){
    	 try {
     		if(nome != null && cpf != null) {
     			if(!(AdministradorRepository.getListaAdministradorCpf().contains(cpf))){
					eventoDAO.inserirADM(nome, cpf);
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
    public int removerADM(Administrador ADM){
    	try {
     		if(AdministradorRepository.getListaAdministradorCpf().contains(ADM.getCpf())) {
				eventoDAO.removerADM(ADM);
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
    public Administrador buscarADM(String cpf){
    	try {
    		if(AdministradorRepository.getListaAdministradorCpf().contains(cpf)){
       			return (eventoDAO.buscarADM(cpf));
       		}else {
       			throw new NumberFormatException();
       		}
       	}catch(NumberFormatException e){
			System.out.println("ERRO: Administrador não existe.");
			return null;
       	}
    } 
    @Override
    public List <Administrador> buscarTodosADM(){
		return eventoDAO.buscarTodosADM();
    }

    @Override
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
    	 return ((double)avaliacoesServico/(double)quantAvServico);
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
	public ArrayList<String> calcularRankingHorarios(List<String> horarios, List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios) {
		List<Double> medias = calcularMediaAvaliacaoHorario(avaliacoesHorarios, quantAvHorarios);
		ArrayList<String> rankingHorarios = new ArrayList<>();
		EventoRepository.setMedias(medias);

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
