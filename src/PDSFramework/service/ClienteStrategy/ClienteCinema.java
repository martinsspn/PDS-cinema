package PDSFramework.service.ClienteStrategy;

import PDSFramework.DAO.SingletonEventoDAO;
import PDSFramework.model.Evento;
import PDSFramework.repository.CinemaRepository;

public class ClienteCinema extends ClienteStrategyAbstractEvento{
    PDSFramework.DAO.ClienteStrategy.ClienteCinema clienteCinema = (PDSFramework.DAO.ClienteStrategy.ClienteCinema) SingletonEventoDAO.getCliente().getClienteStrategyEventoDAO();

    @Override
    public Evento buscarEvento(String nome){
        try {
            if(!CinemaRepository.getFilmesEmCartaz().isEmpty()) {
                return SingletonEventoDAO.getAdm().buscarEvento(nome);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
}
