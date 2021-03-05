package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.DAO.AdministradorDAO;
import com.PDSCinema.PDSCinemaApplicantion.model.*;

import java.io.IOException;
import java.util.ArrayList;

public class AdmistradorService implements iAdministradorService{
    private final Administrador adm;
    private final AdministradorDAO admDAO;

    public AdmistradorService(Administrador adm, AdministradorDAO admDAO) {
        this.adm = adm;
        this.admDAO = admDAO;
    }

    @Override
    public void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
            String diaDeEstreia) {
        Filme filme = new Filme();
        filme.setName(name);
        filme.setAvaliacoes(avaliacao);
        filme.setSinopse(sinopse);
        filme.setClassificacaoIndicativa(classificacaoIndicativa);
        filme.setGenero(genero);

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
    public Filme buscarFilme(String nome) throws IOException{
        try{
            return admDAO.buscarFilme(nome);
        }catch (IOException e) {
            throw e;
        }
    }

    @Override
    public ArrayList<Filme> buscarFilmeGenero(String genero) throws IOException{
        try {
            return admDAO.buscarFilmeGenero(genero);
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
    public int removerFilmes(Filme filme) throws IOException {
        try{
            admDAO.removerFilmes(filme);
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
