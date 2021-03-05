package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.DAO.CinemaDAO;
import com.PDSCinema.PDSCinemaApplicantion.model.Administrador;
import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaService{
    private Cinema cinema;
	private CinemaDAO cinemaDAO;

    @Override
	public int inserirCliente(String cpf, String nome){
		try {
			if(nome != null && (cinema.getListaClientesCpf().contains(cpf))) {
				cinemaDAO.inserirCliente(cpf, nome);
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
    public Cliente buscarCliente(String cpf, Cinema cinema){
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
    public List <Cliente> buscarTodosCliente(){
		return cinemaDAO.buscarTodosCliente();
    }

    @Override
    public int inserirADM(Administrador ADM){
    	 try {
     		if(ADM.getNome() != null && !(cinema.getListaAdministradorCpf().contains(ADM.getCpf()))) {
				cinemaDAO.inserirADM(ADM);
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
		return cinemaDAO.buscarTodosADM();
    }

    @Override
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
    	 return ((double)avaliacoesServico/(double)quantAvServico);

    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<Filme> filmesEmCartaz){
    	List<Double> valor = new ArrayList<>();
		for (Filme filme : filmesEmCartaz) {
			valor.add((double) ((filme.getAvaliacoes()) / (filme.getQuantAvaliacoes())));
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
}
