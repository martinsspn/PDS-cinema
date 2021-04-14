package PDSCinema.service;

import PDSCinema.DAO.AdministradorDAO;
import PDSCinema.DAO.AdministradorDAOmemoria;
import PDSCinema.DAO.SingletonEventoDAO;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.repository.EventoRepository;

import java.io.IOException;
import java.util.ArrayList;

public class AdministradorService implements iAdministradorService{
    private final AdministradorDAO admDAO = SingletonEventoDAO.getAdm();

    @Override
    public int cadastrarCupons(String _cupom, double tipoDeCupom) {
        try{
            if(!_cupom.equals("") && tipoDeCupom >= 0){
                admDAO.cadastrarCupons(_cupom, tipoDeCupom);
                return 0;
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return -1;
        }
    }

    @Override
    public int cadastrarPremios(String descricao, int id, int condicao) {
        try{
            if(!descricao.equals("") && condicao > 0){
                if(!EventoRepository.getListaDePremios().containsKey(id)) {
                    admDAO.cadastrarPremios(descricao, id, condicao);
                    return 0;
                }else{
                    throw new IllegalArgumentException();
                }
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return -2;
        }catch (IllegalArgumentException e){
            return -1;
        }
    }



    @Override
    public Cupom buscarCupons(String codigo){
        //Função DAO
        try{
            if(!codigo.equals("") && EventoRepository.getListaDeCupons().containsKey(codigo)){
                return admDAO.buscarCupons(codigo);
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return null;
        }
    }

    @Override
    public Premio buscarPremio(int codigo){
        try{
            if(codigo >= 0){
                return admDAO.buscarPremio(codigo);
            }else{
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e){
            return null;
        }
    }

    @Override
    public int removerCupons(Cupom cupom){
        try{
            System.out.println(EventoRepository.getListaDeCupons().get(cupom.getCodigo()).getCodigo());
            if(EventoRepository.getListaDeCupons().containsKey(cupom.getCodigo())){
                admDAO.removerCupons(cupom);
                return 0;
            }else{
                throw new IOException();
            }
        }catch(IOException e){
            return -1;
        }catch(NullPointerException e){
            return -2;
        }
    }
    @Override
    public int removerPremios(Premio premio){
        try{
            if(premio != null && EventoRepository.getListaDePremios().containsKey(premio.getIdPremio())){
                admDAO.removerPremios(premio);
                return 0;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            return 1;
        }
    }
}
