package PDSCinema.Controller;

import PDSCinema.model.Cupom;
import PDSCinema.model.Filme;
import PDSCinema.model.Premio;
import PDSCinema.repository.CinemaRepository;
import PDSCinema.service.AdministradorService;

import java.util.ArrayList;

public class AdministradorController {
    private final AdministradorService adm;
    AdministradorController(AdministradorService adm){
        this.adm = adm;
    }
    public int cadastrarFilmes(CinemaRepository cinema, String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                        String diaDeEstreia){
        int status = adm.cadastrarFilmes(cinema, name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
        if(status == 0){
            System.out.println("Filme cadastrado com sucesso");
            return 0;
        }else if(status == -1){
            System.out.println("A duração não pode ser menor que 0!");
            return -1;
        }else if(status == -2){
            System.out.println("Algum valor passado está nulo!");
            return -2;
        }
        return -3;
    }
    public int cadastrarCupons(CinemaRepository cinema, String _Cupom, double tipoDeCupom){
        int status = adm.cadastrarCupons(cinema, _Cupom, tipoDeCupom);
        if(status == 0){
            System.out.println("Cupom cadastrado com sucesso");
            return 0;
        }else{
            System.out.println("Nome do cupom ou tipo do cupom inválido!");
            return -1;
        }
    }
    public int cadastrarPremios(CinemaRepository cinema, String descricao, int id){
        int status = adm.cadastrarPremios(cinema, descricao, id);
        if(status == 0){
            System.out.println("Premio cadastrado com sucesso");
            return 0;
        }else if(status == -1){
            System.out.println("Este cupom já existe!");
            return -1;
        }else{
            System.out.println("Valor para o nome do cupom inválido!");
            return -2;
        }
    }

    public Filme buscarFilme(CinemaRepository cinema, String nome){
        Filme filme = adm.buscarFilme(cinema, nome);
        if(filme != null){
            System.out.println("Filme encontrado com sucesso");
            return filme;
        }
        System.out.println("Filme não encontrado");
        return null;
    }
    public ArrayList<Filme> buscarFilmeGenero(CinemaRepository cinema, String genero){
        ArrayList<Filme> filmes = adm.buscarFilmeGenero(cinema, genero);
        if(filmes != null){
            System.out.println("Filmes do gênero " + genero + " encontrados com sucesso");
            return filmes;
        }
        System.out.println("Nenhum filme com esse gênero encontrado!");
        return null;
    }
    public Cupom buscarCupons(CinemaRepository cinema, String codigo){
        Cupom cupom = adm.buscarCupons(cinema, codigo);
        if(cupom != null){
            System.out.println("Cupom encontrados com sucesso");
            return cupom;
        }
        System.out.println("Nenhum cupom encontrado!");
        return null;
    }
    public Premio buscarPremio(CinemaRepository cinema, int codigo){
        Premio premio = adm.buscarPremio(cinema, codigo);
        if(premio != null){
            System.out.println("Premio encontrados com sucesso");
            return premio;
        }
        System.out.println("Nenhum premio encontrado!");
        return null;
    }

    public int removerFilmes(CinemaRepository cinema, Filme filme){
        int status = adm.removerFilmes(cinema, filme);
        if(status == 0){
            System.out.println("Filme removido com sucesso");
            return 0;
        }else{
            System.out.println("Filme não cadastrado!");
            return -1;
        }
    }
    public int removerCupons(CinemaRepository cinema, Cupom cupom){
        int status = adm.removerCupons(cinema, cupom);
        if(status == 0){
            System.out.println("Cupom removido com sucesso");
            return 0;
        }else{
            System.out.println("Cupom não cadastrado!");
            return -1;
        }
    }
    public int removerPremios(CinemaRepository cinema, Premio premio){
        int status = adm.removerPremios(cinema, premio);
        if(status == 0){
            System.out.println("Premio removido com sucesso");
            return 0;
        }else{
            System.out.println("Premio não cadastrado!");
            return -1;
        }
    }
}
