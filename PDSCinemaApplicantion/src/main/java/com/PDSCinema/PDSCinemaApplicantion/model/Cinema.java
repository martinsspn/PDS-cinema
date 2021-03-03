package com.PDSCinema.PDSCinemaApplicantion.model;

import java.util.List;

public class Cinema {
    private List<Integer> salas;
    private List<String> filmesEmCartaz;
    private List<String> horarios;
    private float avaliacoesServico;
    private List<Float> avaliacoesHorarios;
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

    public float getAvaliacoesServico() {
        return avaliacoesServico;
    }

    public void setAvaliacoesServico(float avaliacoesServico) {
        this.avaliacoesServico = avaliacoesServico;
    }

    public List<Float> getAvaliacoesHorarios() {
        return avaliacoesHorarios;
    }

    public void setAvaliacoesHorarios(List<Float> avaliacoesHorarios) {
        this.avaliacoesHorarios = avaliacoesHorarios;
    }
}
