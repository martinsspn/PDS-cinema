package PDSCinema.DAO;

import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;


import java.io.IOException;
import java.util.ArrayList;

public class AdministradorDAOmemoria implements AdministradorDAO{

    @Override
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

    @Override
    public void cadastrarCupons(CinemaRepository cinema, String _Cupom, double tipoDeCupom){
        Cupom cupom = new Cupom();
        cupom.setTipoDeCupom(tipoDeCupom);
        cupom.setCodigo(_Cupom);
        cinema.getListaDeCupons().put(_Cupom, cupom);
    }

    @Override
    public void cadastrarPremios(CinemaRepository cinema, String descricao){
        Premio premio = new Premio();
        premio.setDescricao(descricao);
        premio.setIdPremio(cinema.getListaDePremios().size());
        cinema.getListaDePremios().put(premio.getIdPremio(), premio);
    }

    @Override
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

    @Override
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

    @Override
    public Cupom buscarCupons(CinemaRepository cinema, String codigo){
        return cinema.getListaDeCupons().get(codigo);
    }

    @Override
    public Premio buscarPremio(CinemaRepository cinema, int codigo){
        return cinema.getListaDePremios().get(codigo);
    }

    @Override
    public int removerFilmes(CinemaRepository cinema, Filme filme) throws IOException{
        if(filme != null && cinema.getFilmesEmCartaz().contains(filme)){
            cinema.getFilmesEmCartaz().remove(filme);
            return 0;
        }else{
            throw new IOException();
        }
    }

    @Override
    public int removerCupons(CinemaRepository cinema, Cupom cupom){
        cinema.getListaDeCupons().remove(cupom.getCodigo());
        for(Cliente c: cinema.getListaClientes()){
            if(c.getCuponsAtivos().contains(cupom))
                c.getCuponsAtivos().remove(cupom);
        }
        return 1;
    }

    @Override
    public int removerPremios(CinemaRepository cinema, Premio premio){
        cinema.getListaDePremios().remove(premio.getIdPremio());
        for(Cliente c: cinema.getListaClientes()){
            if(c.getPremios().contains(premio))
                c.getPremios().remove(premio);
        }
        return 1;
    }
}
