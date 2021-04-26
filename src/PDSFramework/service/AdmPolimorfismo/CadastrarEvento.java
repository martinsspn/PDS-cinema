package PDSFramework.service.AdmPolimorfismo;

import PDSFramework.DAO.AdministradorDAO;
import PDSFramework.DAO.AdministradorDAOmemoria;

import java.io.IOException;

public class CadastrarEvento {
    AdministradorDAOmemoria admDAO;
    public CadastrarEvento(AdministradorDAO admDAO){
        this.admDAO = (AdministradorDAOmemoria) admDAO;
    }
    public int cadastrarEvento(String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                                      String diaDeEstreia) {
        try{
            if(!name.isEmpty() && !sinopse.isEmpty()&& !classificacaoIndicativa.isEmpty() && !genero.isEmpty() && !diaDeEstreia.isEmpty()){
                if(duracao >= 0){
                    admDAO.getCadastrarEvento().cadastrarEvento(name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
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
