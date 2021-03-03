package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cinema;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Ingresso;

public class ClienteService implements iClienteService{
    
	
	@Override
    public int comprarIngresso(Ingresso ingresso, int pagamento) {
    	try {
    		if(ingresso.getPreco() == pagamento) {
    			return 0;
    		}else {
    			throw new NumberFormatException();
    		}
    	}catch(NumberFormatException e) {
    		return -1;
    	}
    }

    @Override
    public int avaliarFilme(Filme filme, int avaliacao) {
    	try {
    		if(avaliacao > 5) {
    			throw new NumberFormatException();
    		}
    		int avaliacoes = filme.getAvaliacoes();
    		filme.setAvaliacoes(avaliacoes+avaliacao);
    		filme.setAvaliacoes(filme.getQuantAvaliacoes()+1);
    		return 0;
    	}catch(NumberFormatException e) {
    		return -1;
    	}
    }

    @Override
    public int avaliarServico(Cinema cinema, int avaliacao) {
    	try {
    		if(avaliacao > 5 || avaliacao < 0) {
    			throw new NumberFormatException();
    		}
    		int avaliacoes = cinema.getAvaliacoesServico();
    		cinema.setAvaliacoesServico(avaliacoes+avaliacao);
    		cinema.setQuantAvServico(cinema.getQuantAvServico()+1);
    		return 0;
    	}catch(NumberFormatException e) {
    		return -1;
    	}
    }

    @Override
    public int avaliarHorario(Cinema cinema, int avaliacao) {
		if(avaliacao > 5 || avaliacao < 0) {
			throw new NumberFormatException();
		}
		int avaliacoes = cinema.getAvaliacoesHorarios();
		cinema.setAvaliacoesHorarios(avaliacoes+avaliacao);
		cinema.setQuantAvHorarios(cinema.getQuantAvHorarios()+1);
		return 0;
	}

    @Override
    public int utilizarCupom() {
    	return 0;
    }

    @Override
    public int compartilharCupom() {
    	return 0;
    }

    @Override
    public int resgatarPremio() {
    	return 0;
    }

}
