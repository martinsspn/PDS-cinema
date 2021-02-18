package com.PDSCinema.PDSCinemaApplicantion.model;

import java.util.List;

public class Cinema {
    private List<Integer> salas;
    private List<String> filmesEmCartaz;
    private List<Float> avaliacoesServico;
    private List<Float> avaliacoesHorarios;
    private float mediaServico;
    private float mediaHorarios;

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

    public float getMediaServico() {
        return mediaServico;
    }

    public void setMediaServico(float mediaServico) {
        this.mediaServico = mediaServico;
    }

    public float getMediaHorarios() {
        return mediaHorarios;
    }

    public void setMediaHorarios(float mediaHorarios) {
        this.mediaHorarios = mediaHorarios;
    }
    public List<Float> getAvaliacoesServico() {
        return avaliacoesServico;
    }

    public void setAvaliacoesServico(List<Float> avaliacoesServico) {
        this.avaliacoesServico = avaliacoesServico;
    }

    public List<Float> getAvaliacoesHorarios() {
        return avaliacoesHorarios;
    }

    public void setAvaliacoesHorarios(List<Float> avaliacoesHorarios) {
        this.avaliacoesHorarios = avaliacoesHorarios;
    }
}
