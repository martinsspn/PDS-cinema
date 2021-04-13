package PDSCinema.DAO;

public class SingletonEventoDAO {
    private AdministradorDAO adm = new AdministradorDAOmemoria();
    private ClienteDAO cliente = new ClienteDAOmemoria();
    private EventoDAO evento = new EventoDAOmemoria();

    public AdministradorDAO getAdm() {
        return adm;
    }

    public void setAdm(AdministradorDAO adm) {
        this.adm = adm;
    }

    public ClienteDAO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDAO cliente) {
        this.cliente = cliente;
    }

    public EventoDAO getEvento() {
        return evento;
    }

    public void setEvento(EventoDAO evento) {
        this.evento = evento;
    }
}
