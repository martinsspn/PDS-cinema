package PDSCinema.DAO;

import PDSCinema.model.Cliente;
import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;

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
    public void cadastrarPremios(CinemaRepository cinema, String descricao, int id, int condicao){
        Premio premio = new Premio();
        premio.setDescricao(descricao);
        premio.setIdPremio(id);
        premio.setCondicao(condicao);
        cinema.getListaDePremios().put(premio.getIdPremio(), premio);
        for(Cliente cliente : cinema.getListaClientes()){
            cliente.getPremios().add(premio);
            cliente.getCondicoesPremios().add(0);
        }
    }

    @Override
    public Filme buscarFilme(CinemaRepository cinema, String nome){
        for(Filme filme : cinema.getFilmesEmCartaz()) {
            if (filme.getName().equalsIgnoreCase(nome))
                return filme;
        }
        return null;
    }

    @Override
    public ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero){
        ArrayList<Filme> filmesPorGenero = new ArrayList<>();
        for(Filme filme : cinema.getFilmesEmCartaz()) {
            if (filme.getGenero().equalsIgnoreCase(genero))
                filmesPorGenero.add(filme);
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
    public int removerFilmes(CinemaRepository cinema, Filme filme){
        cinema.getFilmesEmCartaz().remove(filme);
        return 0;
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
