package com.PDSCinema.PDSCinemaApplicantion.service;

import com.PDSCinema.PDSCinemaApplicantion.model.*;

public interface iAdministradorService {
    void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    void cadastrarCupons(String _Cupom, String tipoDeCupom);
    void cadastrarPremios(String descricao);

    Filme buscarFilme(String nome);
    Filme buscarFilmeGenero(String genero);
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(String codigo);

    int removerFilmes(Filme filme, Cinema cinema);
    int removerCupons(Cupom cupom, Cliente cliente);
    int removerPremios(Premio premio, Cliente cliente);
}
