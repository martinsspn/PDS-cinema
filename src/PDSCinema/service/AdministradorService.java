package PDSCinema.service;

import PDSCinema.DAO.AdministradorDAO;
import PDSCinema.DAO.AdministradorDAOmemoria;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

import java.io.IOException;
import java.util.ArrayList;

public class AdministradorService implements iAdministradorService{
    //private final Administrador adm;
    private final AdministradorDAO admDAO;

    public AdministradorService() {
        //this.adm = new Administrador();
        this.admDAO = new AdministradorDAOmemoria();
    }

    @Override
    public int cadastrarFilmes(CinemaRepository cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                                String diaDeEstreia) {
        try{
            if(cinema != null && name != null && sinopse != null && classificacaoIndicativa != null && genero != null && diaDeEstreia != null){
                if(duracao >= 0){
                    admDAO.cadastrarFilmes(cinema, name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
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

    @Override
    public int cadastrarCupons(CinemaRepository cinema, String _cupom, double tipoDeCupom) {
        try{
            if(!_cupom.equals("") && tipoDeCupom >= 0){
                admDAO.cadastrarCupons(cinema, _cupom, tipoDeCupom);
                return 0;
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return -1;
        }
    }

    @Override
    public int cadastrarPremios(CinemaRepository cinema, String descricao, int id) {
        try{
            if(!descricao.equals("")){
                if(!cinema.getListaDePremios().containsKey(id)) {
                    admDAO.cadastrarPremios(cinema, descricao, id);
                    return 0;
                }else{
                    throw new IllegalArgumentException();
                }
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return -1;
        }catch (IllegalArgumentException e){
            return -2;
        }
    }

    @Override
    public Filme buscarFilme(CinemaRepository cinema, String nome){
        try {
            if(!cinema.getFilmesEmCartaz().isEmpty()) {
                return admDAO.buscarFilme(cinema, nome);
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero){
        if(!cinema.getFilmesEmCartaz().isEmpty() && !genero.isEmpty()){
            return admDAO.buscarFilmeGenero(cinema, genero);
        }
        else{
            return null;
        }
    }

    @Override
    public Cupom buscarCupons(CinemaRepository cinema, String codigo){
        //Função DAO
        try{
            if(!codigo.equals("") && cinema.getListaDeCupons().containsKey(codigo)){
                return admDAO.buscarCupons(cinema, codigo);
            }else{
                throw new IOException();
            }
        }catch (IOException e){
            return null;
        }
    }

    @Override
    public Premio buscarPremio(CinemaRepository cinema, int codigo){
        try{
            if(codigo > 0 && codigo <= cinema.getListaDePremios().size()){
                return admDAO.buscarPremio(cinema, codigo);
            }else{
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e){
            return null;
        }
    }

    @Override
    public int removerFilmes(CinemaRepository cinema, Filme filme){
        if(cinema.getFilmesEmCartaz().contains(filme)) {
            admDAO.removerFilmes(cinema, filme);
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public int removerCupons(CinemaRepository cinema, Cupom cupom){
        try{
            if(cupom != null && cinema.getListaDeCupons().containsKey(cupom.getCodigo())){
                admDAO.removerCupons(cinema, cupom);
                return 0;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            return -1;
        }
    }
    @Override
    public int removerPremios(CinemaRepository cinema, Premio premio){
        try{
            if(premio != null && cinema.getListaDePremios().containsKey(premio.getIdPremio())){
                admDAO.removerPremios(cinema, premio);
                return 0;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            return 1;
        }
    }
}
