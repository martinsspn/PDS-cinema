package com.PDSCinema.PDSCinemaApplicantion.service;

public interface iAdministradorService {
    void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    void removerFilmes();
    void cadastrarCupons(String _Cupom, String tipoDeCupom);
    void cadastrarPremios(String descricao);
}
