package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Administrador;
import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Cliente;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class CinemaService implements iCinemaService{
    private Cinema cinema;

    @Override
    public int inserirCliente(Cliente cliente){
    	try {
    		if(cliente.getNome() != null && !(cinema.getListaClientesCpf().contains(cliente.getCpf()))) {
    			//chamar função do DAO para inserir
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
     			//chamar função do DAO para remover
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
      			//chamar função do DAO para buscar
      			Cliente cliente = new Cliente(); //por enquanto q a função não está pronta
      			return cliente;
      		}else {
      			throw new NumberFormatException();
      		}
      	}catch(NumberFormatException e) {
      		return null;
      	}

    } 
    @Override
    public List <Cliente> buscarTodosCliente(){
    	//chamar função do DAO que retorna todos os clientes
		return null;
    }

    @Override
    public int inserirADM(Administrador ADM){
    	 try {
     		if(ADM.getNome() != null && !(cinema.getListaAdministradorCpf().contains(ADM.getCpf()))) {
     			//chamar função do DAO para inserir
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
     			//chamar função do DAO para remover
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
       			//chamar função do DAO para buscar
       			Administrador Adm = new Administrador(); //por enquanto q a função não está pronta
       			return Adm;
       		}else {
       			throw new NumberFormatException();
       		}
       	}catch(NumberFormatException e){
       		return null;
       	}
    } 
    @Override
    public List <Administrador> buscarTodosADM(){
    	//chamar função do DAO que retorna todos os adms
		return null;
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
