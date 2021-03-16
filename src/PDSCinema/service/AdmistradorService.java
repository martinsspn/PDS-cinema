package PDSCinema.service;

import PDSCinema.DAO.AdministradorDAO;
import PDSCinema.DAO.AdministradorDAOmemoria;
import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;

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
    public void cadastrarFilmes(CinemaRepository cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                                String diaDeEstreia) {
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
    public Filme buscarFilme(CinemaRepository cinema, String nome) throws IOException{
        try{
            return admDAO.buscarFilme(cinema, nome);
        }catch (IOException e) {
            throw e;
        }
    }

    @Override
    public ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero) throws IOException{
        try {
            return admDAO.buscarFilmeGenero(cinema, genero);
        }catch (IOException e){
            throw e;
        }
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
    public int removerFilmes(CinemaRepository cinema, Filme filme) throws IOException {
        try{
            admDAO.removerFilmes(cinema, filme);
            return 0;
        }catch(IOException e){
            throw e;
        }
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
