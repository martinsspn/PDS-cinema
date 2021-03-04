package com.PDSCinema.PDSCinemaApplicantion.model;

import java.util.List;

public class Cinema {
    private List<Integer> salas;
    private List<String> filmesEmCartaz;
    private List<String> horarios;
    private int avaliacoesServico;
    private List<Integer> avaliacoesHorarios;
    private int quantAvServico;
    private List<Integer> quantAvHorarios;

    public List<Integer> getSalas() {
        return salas;
    }

    public void setSalas(List<Integer> salas) {
        this.salas = salas;
    }

    public List<String> getFilmesEmCartaz() {
        return filmesEmCartaz;
    }

    public void setFilmesEmCartaz(List<String> filmesEmCartaz) {
        this.filmesEmCartaz = filmesEmCartaz;
   }

    public int getAvaliacoesServico() {
        return avaliacoesServico;
    }

    public void setAvaliacoesServico(int avaliacoesServico) {
        this.avaliacoesServico = avaliacoesServico;
    }
public int getQuantAVServico() {
        return quantAvServico;
    }

    public void setQuantAvServico(int quantAvServico) {
        this.quantAvServico = quantAvServico;
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
