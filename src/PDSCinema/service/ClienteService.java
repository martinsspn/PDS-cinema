package PDSCinema.service;

import java.io.IOException;

import PDSCinema.DAO.ClienteDAO;
import PDSCinema.DAO.ClienteDAOmemoria;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.model.Filme;
import PDSCinema.model.Ingresso;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class ClienteService implements iClienteService{
    private Cliente cliente;
	private ClienteDAO clienteDAO;

	public ClienteService() {
		this.cliente = new Cliente();
		this.clienteDAO = new ClienteDAOmemoria();
	}

	@Override
    public int comprarIngresso(Ingresso ingresso, int pagamento) {
    	try {
    		if(ingresso.getPreco() == pagamento) {
    			clienteDAO.comprarIngresso(ingresso);
    			return 0;
    		}else {
    			throw new NumberFormatException();
    		}
    	}catch(NumberFormatException e) {
    		return -1;
    	}catch (NullPointerException e){
    		return -2;
		}
    }

    @Override
    public int avaliarFilme(Filme filme, int avaliacao) {
    	try {
    		if(avaliacao > 5 || avaliacao < 0) {
    			throw new NumberFormatException();
    		}
    		clienteDAO.avaliarFilme(filme, avaliacao);

    		return 0;
    	}catch(NumberFormatException e) {
    		return -1;
    	}catch(NullPointerException e){
    		return -2;
		}
    }

    @Override
    public int avaliarServico(Cinema cinema, int avaliacao) {
    	try {
    		if(avaliacao > 5 || avaliacao < 0) {
    			throw new NumberFormatException();
    		}
    		clienteDAO.avaliarServico(cinema, avaliacao);
    		return 0;
    	}catch(NumberFormatException e) {
    		return -1;
    	}catch (NullPointerException e){
    		return -2;
		}
    }

    @Override
    public int avaliarHorario(Cinema cinema, String horario, int avaliacao) {
		try {
			if(avaliacao > 5 || avaliacao < 0) {
				throw new NumberFormatException();
			}
			if(horario.isEmpty()){
				throw new Invalid();
			}
			clienteDAO.avaliarHorario(cinema, horario, avaliacao);
			return 0;
		}catch(NumberFormatException e) {
			return -1;
		}catch (NullPointerException e){
			return -2;
		}catch(IOException e) {
			return -3;
		} catch (Invalid e) {
			return -4;
		}
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

    public Cliente getCliente(){
		return cliente;
	}
}
