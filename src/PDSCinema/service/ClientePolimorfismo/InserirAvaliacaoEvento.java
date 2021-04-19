package PDSCinema.service.ClientePolimorfismo;

import PDSCinema.DAO.*;
import PDSCinema.model.Evento;

public class InserirAvaliacaoEvento {


    public int inserirAvaliacaoEvento(Evento evento, int avaliacao) {
        try {
            if(avaliacao > 5 || avaliacao < 0) {
                throw new NumberFormatException();
            }
            SingletonEventoDAO.getCliente().getInserirAvaliacaoEvento().inseriAvaliacaoEvento(evento, avaliacao);
            return 0;
        }catch(NumberFormatException e) {
            return -1;
        }catch(NullPointerException e){
            return -2;
        }
    }
}
