package PDSCinema.service.ClientePolimorfismo;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.Evento;

public class AvaliarEvento {
    public static int avaliarEvento(Evento evento, int avaliacao) {
        try {
            if(avaliacao > 5 || avaliacao < 0) {
                throw new NumberFormatException();
            }
            PDSCinema.DAO.ClientePolimorfismo.AvaliarEvento.avaliarEvento(evento, avaliacao);

            return 0;
        }catch(NumberFormatException e) {
            return -1;
        }catch(NullPointerException e){
            return -2;
        }
    }
}
