package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.Cupom;
import com.PDSCinema.PDSCinemaApplicantion.model.Filme;
import com.PDSCinema.PDSCinemaApplicantion.model.Premio;

public interface iAdministradorService {
    void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    void cadastrarCupons(String _Cupom, String tipoDeCupom);
    void cadastrarPremios(String descricao);

    Filme buscarFilme(String nome);
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(String codigo);

    void removerFilmes(Filme filme);
    void removerCupons(Cupom cupom);
    void removerPremios(Premio premio);
}
