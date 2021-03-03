package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import java.util.List;

public class CinemaService implements iCinemaService{
    private Cinema cinema;

    @Override
    public void inserirCliente(Cliente cliente){
    	try {
    		if(cliente.getNome() != NULL && !(cinema.getListaClientesCpf().Contains(cliente.getCpf()))) { 
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
    public void removerCliente(Cliente cliente, Cinema cinema){
    	 try {
     		if(cinema.getListaClientesCpf().Contains(cliente.getCpf())) { 
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
      		if(cinema.getListaClientesCpf().Contains(cpf) { 
      			//chamar função do DAO para buscar
      			cliente = new Cliente(); //por enquanto q a função não está pronta
      			return cliente;
      		}else {
      			throw new NumberFormatException();
      		}
      	}catch(NumberFormatException e) {
      		return -1;
      	}

    } 
    @Override
    public List <Cliente> buscarTodosCliente(){
    	//chamar função do DAO que retorna todos os clientes

    }
     @Override
    public void inserirADM(Administrador ADM){
    	 try {
     		if(ADM.getNome() != NULL && !(cinema.getListaAdministradorCpf().Contains(ADM.getCpf()))) { 
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
    public void removerADM(Administrador ADM, Cinema cinema){
    	try {
     		if(cinema.getListaAdministradorCpf().Contains(ADM.getCpf())) { 
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
       		if(cinema.getListaAdministradorCpf().Contains(cpf) { 
       			//chamar função do DAO para buscar
       			Adm = new Administrador(); //por enquanto q a função não está pronta
       			return Adm;
       		}else {
       			throw new NumberFormatException();
       		}
       	}catch(NumberFormatException e) {
       		return -1;
       	}
    } 
    @Override
    public List <Administrador> buscarTodosADM(){
    	//chamar função do DAO que retorna todos os adms
    }
     @Override
    public Double calcularMediaAvaliacaoServico(int avaliacoesServico, int quantAvServico){
    	 return (avaliacoesServico/quantAvServico);

    }
    public List<Double> calcularMediaAvaliacaoFilmes(List<String> filmesEmCartaz){
    	List<Double> valor;
	   	 for(int i=0; i < filmesEmCartaz.size(); i++){
	   		 valor.add((filmesEmCartaz.get(i).avaliacoes)/(filmesEmCartaz.get(i).quantAvaliacoes))
	   	 }
    	return valor;

   }
     public List<Double> calcularMediaAvaliacaoHorario(List<Integer> avaliacoesHorarios, List<Integer> quantAvHorarios){
    	 List<Double> valor;
    	 for(int i=0; i < avaliacoesHorarios.size(); i++){
    		 valor.add(avaliacoesHorarios.get(i)/quantAvHorarios(i))
    	 }
    	 return valor;

    }
    
}
