package PDSCinema.repository;

import PDSCinema.model.*;
import PDSCinema.service.ClienteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CinemaRepository extends EventoRepository{
    private List<Integer> salas;
    private List<Filme> filmesEmCartaz;
    private List<String> horarios;
    private List<Integer> avaliacoesHorarios;
    private List<Integer> quantAvHorarios;

    public CinemaRepository() {
        this.salas = new ArrayList<>();
        this.filmesEmCartaz = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.avaliacoesServico = 0;
        this.avaliacoesHorarios = new ArrayList<>();
        this.quantAvServico = 0;
        this.quantAvHorarios = new ArrayList<>();
        this.medias = new ArrayList<>();
        this.listaDeCupons = new HashMap<>();
        this.listaDePremios = new HashMap<>();
        horarios.add("12h30min");
        horarios.add("13h00min");
        horarios.add("13h30min");
        horarios.add("14h00min");
        horarios.add("14h30min");
        horarios.add("15h30min");
        horarios.add("17h00min");
        horarios.add("18h30min");
        horarios.add("20h00min");
        for(int i=0;i<10;i++){
            avaliacoesHorarios.add(0);
            quantAvHorarios.add(0);
        }

    }

    public List<Integer> getSalas() {
        return salas;
    }

    public void setSalas(List<Integer> salas) {
        this.salas = salas;
    }

    public List<Filme> getFilmesEmCartaz() {
        return filmesEmCartaz;
    }

    public void setFilmesEmCartaz(List<Filme> filmesEmCartaz) {
        this.filmesEmCartaz = filmesEmCartaz;
    }

    public List<Integer> getAvaliacoesHorarios() {
        return avaliacoesHorarios;
    }

    public void setAvaliacoesHorarios(List<Integer> avaliacoesHorarios) {
        this.avaliacoesHorarios = avaliacoesHorarios;
    }

    public List<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<String> horarios) {
        this.horarios = horarios;
    }

    public List<Integer> getQuantAvHorarios() {
        return quantAvHorarios;
    }

    public void setQuantAvHorarios(List<Integer> quantAvHorarios) {
        this.quantAvHorarios = quantAvHorarios;
    }
}

