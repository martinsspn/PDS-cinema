package PDSCinema;

import PDSCinema.model.Administrador;
import PDSCinema.model.Cinema;
import PDSCinema.model.Cliente;
import PDSCinema.service.*;

public class main {
    public static void main(String[] args){
        iCinemaService ics = new CinemaService();
        iAdministradorService ids = new AdmistradorService();
        iClienteService icls = new ClienteService();
        ids.cadastrarFilmes(ics.getCinema(), "esqueceram de mim", 120, 0, "uma sinopse qualquer", "15 anos", "comedia"
        , "10/01/2000");
        System.out.println(ics.getCinema().getFilmesEmCartaz().get(0).getName());

    }
}
   // Cinema cinema, String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
   //     String diaDeEstreia