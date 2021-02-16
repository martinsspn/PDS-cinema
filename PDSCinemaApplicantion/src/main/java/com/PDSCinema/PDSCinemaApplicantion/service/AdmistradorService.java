package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cupom;
import com.PDSCinema.PDSCinemaApplicantion.model.Premio;

public class AdmistradorService implements iAdministradorService{

    @Override
    public void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
            String diaDeEstreia) {

    }

    @Override
    public void removerFilmes() {

    }

    @Override
    public void cadastrarCupons(String _Cupom, String tipoDeCupom) {
        Cupom cupom = new Cupom();
        cupom.setTipoDeCupom(_Cupom, tipoDeCupom);
    }

    @Override
    public void cadastrarPremios(String descricao) {
        Premio premio = new Premio();
        premio.setDescricao(descricao);

    }
}
