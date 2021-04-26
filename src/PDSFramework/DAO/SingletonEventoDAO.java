package PDSFramework.DAO;

import PDSFramework.DAO.ADMStrategy.AdmCinema;
import PDSFramework.DAO.ClienteStrategy.ClienteCinema;
import PDSFramework.DAO.ClienteStrategy.ClienteStrategyEventoDAO;
import PDSFramework.DAO.ADMStrategy.AdmStrategyAbstractEvento;

public abstract class SingletonEventoDAO {
    private static AdmStrategyAbstractEvento admStrategyAbstractEvento = new AdmCinema();
    private static ClienteStrategyEventoDAO clienteStrategyEventoDAO = new ClienteCinema();
    private static AdministradorDAO adm = new AdministradorDAOmemoria(admStrategyAbstractEvento);
    private static ClienteDAO cliente = new ClienteDAOmemoria(clienteStrategyEventoDAO);
    private static EventoDAO evento = new EventoDAOmemoria();

    public static ClienteStrategyEventoDAO getClienteStrategyEventoDAO() {
        return clienteStrategyEventoDAO;
    }

    public static void setClienteStrategyEventoDAO(ClienteStrategyEventoDAO clienteStrategyEventoDAO) {
        SingletonEventoDAO.clienteStrategyEventoDAO = clienteStrategyEventoDAO;
    }

    public static AdmStrategyAbstractEvento getAdmStrategyAbstractEvento() {
        return admStrategyAbstractEvento;
    }

    public static void setAdmStrategyAbstractEvento(AdmStrategyAbstractEvento admStrategyAbstractEvento) {
        SingletonEventoDAO.admStrategyAbstractEvento = admStrategyAbstractEvento;
    }

    public static AdministradorDAO getAdm() {
        return adm;
    }

    public static void setAdm(AdministradorDAO adm) {
        SingletonEventoDAO.adm = adm;
    }

    public static ClienteDAO getCliente() {
        return cliente;
    }

    public static void setCliente(ClienteDAO cliente) {
        SingletonEventoDAO.cliente = cliente;
    }

    public static EventoDAO getEvento() {
        return evento;
    }

    public static void setEvento(EventoDAO evento) {
        SingletonEventoDAO.evento = evento;
    }
}
