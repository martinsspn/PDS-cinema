package PDSCinema.DAO;

import PDSCinema.model.Cinema;
import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;

import java.util.ArrayList;

public class AdministradorDAOmemoria implements AdministradorDAO{

    public void cadastrarFilmes(Cinema cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
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

    public Filme buscarFilme(Cinema cinema, String nome){
        for(Filme filme : cinema.getFilmesEmCartaz()){
            if(filme.getName().equals(nome))
                return filme;
        }
        return null;
    }

    public ArrayList<Filme> buscarFilmeGenero(Cinema cinema, String genero){
        ArrayList<Filme> filmesPorGenero = new ArrayList<>();
            for(Filme filme : cinema.getFilmesEmCartaz()) {
                if (filme.getGenero().equals(genero))
                    filmesPorGenero.add(filme);
            }
        return filmesPorGenero;
    }

    public Cupom buscarCupons(String codigo){
        return null;
    }
    public Premio buscarPremio(String codigo){
        return null;
    }

    public int removerFilmes(Cinema cinema, Filme filme){
        cinema.getFilmesEmCartaz().remove(filme);
        return 0;
    }

    public int removerCupons(Cupom cupom){
        return 0;
    }

    public int removerPremios(Premio premio){
        return 0;
    }
}
