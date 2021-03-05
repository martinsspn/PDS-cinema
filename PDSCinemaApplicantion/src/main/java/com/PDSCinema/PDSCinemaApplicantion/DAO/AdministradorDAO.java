package com.PDSCinema.PDSCinemaApplicantion.DAO;

import com.PDSCinema.PDSCinemaApplicantion.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface AdministradorDAO{
    void cadastrarFilmes(String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    void cadastrarCupons(String _Cupom, String tipoDeCupom);
    void cadastrarPremios(String descricao);

    Filme buscarFilme(String nome) throws IOException;
    ArrayList<Filme> buscarFilmeGenero(String genero) throws IOException;
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(String codigo);

    int removerFilmes(Filme filme) throws IOException;
    int removerCupons(Cupom cupom);
    int removerPremios(Premio premio);
}
