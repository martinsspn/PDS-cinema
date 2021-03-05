package PDSCinema.service;

import PDSCinema.model.*;


import java.io.IOException;
import java.util.ArrayList;

public interface iAdministradorService {
    void cadastrarFilmes(Cinema cinema, String name, int duracao, int avaliacao, String sinopse, String classificacaoIndicativa, String genero,
                         String diaDeEstreia);
    void cadastrarCupons(String _Cupom, String tipoDeCupom);
    void cadastrarPremios(String descricao);

    Filme buscarFilme(Cinema cinema, String nome) throws IOException;
    ArrayList<Filme> buscarFilmeGenero(Cinema cinema, String genero) throws IOException;
    Cupom buscarCupons(String codigo);
    Premio buscarPremio(String codigo);

    int removerFilmes(Cinema cinema, Filme filme) throws IOException;
    int removerCupons(Cupom cupom, Cliente cliente);
    int removerPremios(Premio premio, Cliente cliente);
}
