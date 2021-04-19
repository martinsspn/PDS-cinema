package PDSCinema.service.ClienteStrategy;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Evento;
import PDSCinema.repository.CinemaRepository;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.IOException;

public class ClienteCinema extends ClienteStrategyAbstractEvento{
    PDSCinema.DAO.ClienteStrategy.ClienteCinema clienteCinema = (PDSCinema.DAO.ClienteStrategy.ClienteCinema) SingletonEventoDAO.getCliente().getClienteStrategyEventoDAO();

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
