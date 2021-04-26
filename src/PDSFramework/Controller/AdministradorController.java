package PDSFramework.Controller;

import PDSFramework.model.Evento;
import PDSFramework.model.Cupom;
import PDSFramework.model.Filme;
import PDSFramework.model.Premio;
import PDSFramework.service.AdmStrategy.AdmCinema;
import PDSFramework.service.AdministradorService;

import java.util.ArrayList;

public class AdministradorController {
    private AdmCinema admCinema = new AdmCinema();
    private final AdministradorService adm;
    public AdministradorController(){
        this.adm = new AdministradorService();
    }
    public String cadastrarEvento(String name, int duracao, String sinopse, String classificacaoIndicativa, String genero,
                        String diaDeEstreia){
        int status = adm.getCadastrarEvento().cadastrarEvento(name, duracao, sinopse, classificacaoIndicativa, genero, diaDeEstreia);
        if(status == 0){
            return ("Filme cadastrado com sucesso");
        }else if(status == -1){
            return ("A duração não pode ser menor que 0!");
        }else if(status == -2){
            return ("Algum valor passado está nulo!");
        }
        return "Filme não cadastrado!";
    }
    public String cadastrarCupons(String _Cupom, double tipoDeCupom){
        int status = adm.cadastrarCupons(_Cupom, tipoDeCupom);
        if(status == 0){
            return ("Cupom cadastrado com sucesso");
        }else{
            return ("Nome do cupom ou tipo do cupom inválido!");
        }
    }
    public String cadastrarPremios(String descricao, int id, int condicao){
        int status = adm.cadastrarPremios(descricao, id, condicao);
        if(status == 0){
            return ("Premio cadastrado com sucesso");
        }else if(status == -1){
            return ("Este premio já existe!");
        }else{
            return ("Valor para o premio inválido");
        }
    }

    public Evento buscarEvento(String nome){
        Evento evento = admCinema.buscarEvento(nome);
        if(evento != null){
            return evento;
        }
        return null;
    }
    public ArrayList<Filme> buscarFilmeGenero(String genero){
        ArrayList<Filme> filmes = admCinema.buscarFilmeGenero(genero);
        if(filmes != null){
            return filmes;
        }
        return null;
    }
    public Cupom buscarCupons(String codigo){
        Cupom cupom = adm.buscarCupons(codigo);
        if(cupom != null){
            return cupom;
        }
        return null;
    }
    public Premio buscarPremio(int codigo){
        Premio premio = adm.buscarPremio(codigo);
        if(premio != null){
            return premio;
        }
        return null;
    }

    public String removerEvento(Evento evento){
        int status = admCinema.removerEvento(evento);
        if(status == 0){
            return ("Filme removido com sucesso");
        }else{
            return ("Filme não cadastrado!");
        }
    }
    public String removerCupons(Cupom cupom){
        int status = adm.removerCupons(cupom);
        if(status == 0){
            return ("Cupom removido com sucesso");
        }else{
            return ("Cupom não cadastrado!");
        }
    }
    public String removerPremios(Premio premio){
        int status = adm.removerPremios(premio);
        if(status == 0){
            return ("Premio removido com sucesso");
        }else{
            return ("Premio não cadastrado!");
        }
    }
}
