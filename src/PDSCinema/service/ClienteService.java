package PDSCinema.service;

import java.io.IOException;

import PDSCinema.DAO.ClienteDAO;
import PDSCinema.DAO.ClienteDAOmemoria;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.repository.ClienteRepository;
import PDSCinema.repository.EventoRepository;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class ClienteService implements iClienteService{
	private final ClienteDAO clienteDAO;

	public ClienteService() {
		this.clienteDAO = new ClienteDAOmemoria();
	}

	@Override
    public double comprarIngresso(Ingresso ingresso, Cliente cliente, double pagamento, Cupom cupom) {
    	try {
    		if(ingresso.getPreco() <= pagamento + cupom.getTipoDeCupom()) {
    			clienteDAO.comprarIngresso(ingresso, cliente, cupom);
    			return pagamento+cupom.getTipoDeCupom() - ingresso.getPreco();
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
	public double comprarIngresso(Ingresso ingresso, Cliente cliente,double pagamento) {
		try {
			if(ingresso.getPreco() <= pagamento) {
				clienteDAO.comprarIngresso(ingresso, cliente);
				return pagamento - ingresso.getPreco();
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
    public int avaliarServico(CinemaRepository cinema, int avaliacao) {
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
    public int avaliarHorario(CinemaRepository cinema, String horario, int avaliacao) {
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
    public int resgatarCupom(CinemaRepository cinema, Cliente cliente, String codigo){
    	try {
    		if(!codigo.equals("") && cinema.getListaDeCupons().containsKey(codigo)){
				if(!cliente.getCuponsAtivos().contains(cinema.getListaDeCupons().get(codigo)) && !cliente.getCuponsUsados().contains(cinema.getListaDeCupons().get(codigo))){
    				clienteDAO.resgatarCupom(cinema, cliente, codigo);
    				return 0;
				}else{
    				throw new IOException();
				}
			}else{
    			throw new ArrayStoreException();
			}
		}catch (NullPointerException e){
    		return -1;
		}catch (IOException e){
    		return -2;
		}catch (ArrayStoreException e){
			return -3;
		}
    }

	@Override
	public String resgatarPremio(ClienteRepository clienteRepository, EventoRepository eventoRepository, Cliente cliente, int codigo) {
		try{
			if(clienteRepository.getListaClientes().contains(cliente)&& eventoRepository.getListaDePremios().containsKey(codigo)){
				Premio premio = clienteDAO.resgatarPremio(cinema, cliente, codigo);
				if(premio == null){
					throw new NullPointerException();
				}
				int auxiliar = 0;
				for(Premio p: cliente.getPremios()){
					if(p.getIdPremio() == codigo){
						break;
					}
					auxiliar++;
				}
				if(premio.getCondicao() <= cliente.getCondicoesPremios().get(auxiliar)){
					System.out.println(premio.getDescricao());
					clienteDAO.alterarCondicaoPremio(cliente, auxiliar, 0);
					return premio.getDescricao();
				}else {
					return "-2";
				}
			}else{
				throw new IOException();
			}
		}catch (IOException e){
			return "-1";
		}catch (NullPointerException e){
			return "-2";
		}
	}

	@Override
    public String compartilharCupom(Cliente cliente) {
		try{
			String compartilhar = clienteDAO.compartilharCupom(cliente);
			return compartilhar;
		}catch (NullPointerException e){
			return "Cliente não existe";
		}
    }
}
