package PDSCinema.service;

import java.io.IOException;

import PDSCinema.DAO.ClienteStrategy.ClienteCinema;
import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.*;
import PDSCinema.repository.ClienteRepository;
import PDSCinema.repository.EventoRepository;
import PDSCinema.service.ClientePolimorfismo.InserirAvaliacaoEvento;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class ClienteService implements iClienteService{
	private final InserirAvaliacaoEvento inserirAvaliacaoEvento = new InserirAvaliacaoEvento();
	private final ClienteCinema clienteCinema = new ClienteCinema();

	@Override
    public double comprarIngresso(Ingresso ingresso, Cliente cliente, double pagamento, Cupom cupom) {
    	try {
    		if(ingresso.getPreco() <= pagamento + cupom.getTipoDeCupom()) {
				SingletonEventoDAO.getCliente().comprarIngresso(ingresso, cliente, cupom);
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
			if (ingresso.getPreco() <= pagamento) {
				SingletonEventoDAO.getCliente().comprarIngresso(ingresso, cliente);
				return pagamento - ingresso.getPreco();
			} else {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			return -1;
		} catch (NullPointerException e) {
			return -2;
		}
	}

    @Override
    public int inserirAvaliacaoServico(int avaliacao) {
    	try {
    		if(avaliacao > 5 || avaliacao < 0) {
    			throw new NumberFormatException();
    		}
			SingletonEventoDAO.getCliente().avaliarServico(avaliacao);
    		return 0;
    	}catch(NumberFormatException e) {
    		return -1;
    	}catch (NullPointerException e){
    		return -2;
		}
    }

	@Override
	public int inseriAvaliacaoHorario(String horario, int avaliacao) {
		try {
			if(avaliacao > 5 || avaliacao < 0) {
				throw new NumberFormatException();
			}
			if(horario.isEmpty()){
				throw new Invalid();
			}
			clienteCinema.inserirAvaliacaoHorario(horario, avaliacao);
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
    public int resgatarCupom(Cliente cliente, String codigo){
    	try {
    		if(!codigo.equals("") && EventoRepository.getListaDeCupons().containsKey(codigo)){
				if(!cliente.getCuponsAtivos().contains(EventoRepository.getListaDeCupons().get(codigo)) && !cliente.getCuponsUsados().contains(EventoRepository.getListaDeCupons().get(codigo))){
					SingletonEventoDAO.getCliente().resgatarCupom(cliente, codigo);
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
	public String resgatarPremio(Cliente cliente, int codigo) {
		try{
			if(ClienteRepository.getListaClientes().contains(cliente)&& EventoRepository.getListaDePremios().containsKey(codigo)){
				Premio premio = SingletonEventoDAO.getCliente().resgatarPremio(cliente, codigo);
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
					SingletonEventoDAO.getCliente().alterarCondicaoPremio(cliente, auxiliar, 0);
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
			return SingletonEventoDAO.getCliente().compartilharCupom(cliente);
		}catch (NullPointerException e){
			return "Cliente não existe";
		}
    }

	public InserirAvaliacaoEvento getInserirAvaliacaoEvento() {
		return inserirAvaliacaoEvento;
	}

	public ClienteCinema getClienteCinema() {
		return clienteCinema;
	}
}
