package PDSCinema.DAO;

import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;


import java.io.IOException;
import java.util.ArrayList;

public class AdministradorDAOmemoria implements AdministradorDAO{

    public void cadastrarFilmes(CinemaRepository cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                                String diaDeEstreia){
        Filme filme = new Filme();
        filme.setName(name);
        filme.setDuracao(duracao);
        filme.setSinopse(sinopse);
        filme.setClassificacaoIndicativa(classificacaoIndicativa);
        filme.setGenero(genero);
        filme.setDiaDeEstreia(diaDeEstreia);
        cinema.getFilmesEmCartaz().add(filme);
    }

    public void cadastrarCupons(String _Cupom, String tipoDeCupom){

    }
    public void cadastrarPremios(String descricao){

    }

    public Filme buscarFilme(CinemaRepository cinema, String nome) throws IOException{
        if(!nome.isEmpty()){
            for(Filme filme : cinema.getFilmesEmCartaz()){
                if(filme.getName().equals(nome))
                    return filme;
            }
        }else{
            throw new IOException();
        }
        return null;
    }

    public ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero) throws IOException{
        ArrayList<Filme> filmesPorGenero = new ArrayList<>();
        if(!genero.isEmpty()){
            for(Filme filme : cinema.getFilmesEmCartaz()){
                if(filme.getGenero().equals(genero))
                    filmesPorGenero.add(filme);
            }
        }else{
            throw new IOException();
        }
        return filmesPorGenero;
    }
    public Cupom buscarCupons(String codigo){
        return null;
    }
    public Premio buscarPremio(String codigo){
        return null;
    }

    public int removerFilmes(CinemaRepository cinema, Filme filme) throws IOException{
        if(filme != null && cinema.getFilmesEmCartaz().contains(filme)){
            cinema.getFilmesEmCartaz().remove(filme);
            return 0;
        }else{
            throw new IOException();
        }
    }
    public int removerCupons(Cupom cupom){
        return 0;
    }
    public int removerPremios(Premio premio){
        return 0;
    }
}
