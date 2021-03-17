package PDSCinema.service;

import PDSCinema.model.*;
import PDSCinema.repository.CinemaRepository;


import java.io.IOException;
import java.util.ArrayList;

public interface iAdministradorService {
    int cadastrarFilmes(CinemaRepository cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    int cadastrarCupons(CinemaRepository cinema, String _Cupom, double tipoDeCupom);
    int cadastrarPremios(CinemaRepository cinema, String descricao);

    Filme buscarFilme(CinemaRepository cinema, String nome) throws IOException;
    ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero) throws IOException;
    Cupom buscarCupons(CinemaRepository cinema, String codigo);
    Premio buscarPremio(CinemaRepository cinema, int codigo);

    int removerFilmes(CinemaRepository cinema, Filme filme) throws IOException;
    int removerCupons(CinemaRepository cinema, Cupom cupom);
    int removerPremios(CinemaRepository cinema, Premio premio);
}
