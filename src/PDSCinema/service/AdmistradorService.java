package PDSCinema.service;

import PDSCinema.DAO.AdministradorDAO;
import PDSCinema.DAO.AdministradorDAOmemoria;
import PDSCinema.model.*;
import java.io.IOException;
import java.util.ArrayList;

public class AdmistradorService implements iAdministradorService{
    private final Administrador adm;
    private final AdministradorDAO admDAO;

    public AdmistradorService() {
        this.adm = new Administrador();
        this.admDAO = new AdministradorDAOmemoria();
    }

    @Override
    public void cadastrarFilmes(Cinema cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
            String diaDeEstreia) {
        if(cinema != null && duracao > 0 && !sinopse.isEmpty() && !classificacaoIndicativa.isEmpty() && !genero.isEmpty() && !diaDeEstreia.isEmpty())
            admDAO.cadastrarFilmes(cinema, name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
    }

    @Override
    public void cadastrarCupons(String _cupom, String tipoDeCupom) {
        Cupom cupom = new Cupom();
        cupom.setTipoDeCupom(_cupom, tipoDeCupom);
    }

    @Override
    public void cadastrarPremios(String descricao) {
        Premio premio = new Premio();
        premio.setDescricao(descricao);

    }

    @Override
    public Filme buscarFilme(Cinema cinema, String nome){
        if(cinema != null && !nome.isEmpty())
            return admDAO.buscarFilme(cinema, nome);
        else
            return null;
    }

    @Override
    public ArrayList<Filme> buscarFilmeGenero(Cinema cinema, String genero){
        if(cinema != null && !genero.isEmpty())
            return admDAO.buscarFilmeGenero(cinema, genero);
        else
            return null;
    }

    @Override
    public Cupom buscarCupons(String codigo){
        //Função DAO
        return null;
    }

    @Override
    public Premio buscarPremio(String codigo){
        //Função DAO
        return null;
    }

    @Override
    public int removerFilmes(Cinema cinema, Filme filme) {
        if (cinema != null && cinema.getFilmesEmCartaz().contains(filme)){
            admDAO.removerFilmes(cinema, filme);
            return 0;
        }else
            return -1;
    }

    @Override
    public int removerCupons(Cupom cupom, Cliente cliente){
        try{
            if(cliente.getCupons().contains(cupom)){
                //função DAO para remover
                return 0;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            return 1;
        }
    }
    @Override
    public int removerPremios(Premio premio, Cliente cliente){
        try{
            if(cliente.getPremios().contains(premio)){
                //função DAO para remover
                return 0;
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            return 1;
        }
    }
}
