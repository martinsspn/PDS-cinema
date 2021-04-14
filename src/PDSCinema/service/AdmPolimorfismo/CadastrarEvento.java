package PDSCinema.service.AdmPolimorfismo;

import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;

public class CadastrarEvento {
    public static int cadastrarEvento(String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                                      String diaDeEstreia) {
        try{
            if(!name.isEmpty() && !sinopse.isEmpty()&& !classificacaoIndicativa.isEmpty() && !genero.isEmpty() && !diaDeEstreia.isEmpty()){
                if(duracao >= 0){
                    PDSCinema.DAO.AdmPolimorfismo.CadastrarEvento.cadastrarEvento(name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
                    return 0;
                }else{
                    throw new NumberFormatException();
                }
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return -1;
        }catch (NumberFormatException e){
            return -2;
        }
    }


}
