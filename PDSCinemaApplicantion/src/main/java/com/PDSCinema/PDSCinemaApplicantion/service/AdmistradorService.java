package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cupom;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Premio;

public class AdmistradorService implements iAdministradorService{

    @Override
    public void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
            String diaDeEstreia) {
        Filme filme = new Filme();
        filme.setName(name);
        filme.setAvaliacao(avaliacao);
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
    public Filme buscarFilme(String nome){

    }
    @Override
    public Cupom buscarCupons(String codigo){

    }
    @Override
    public Premio buscarPremio(String codigo){

    }

    @Override
    public void removerFilmes(Filme filme) {

    }
    @Override
    public void removerCupons(Cupom cupom){

    }
    @Override
    public void removerPremios(Premio premio){

    }
}
