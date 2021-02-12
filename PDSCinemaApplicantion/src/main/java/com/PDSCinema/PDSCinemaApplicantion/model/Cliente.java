package com.PDSCinema.PDSCinemaApplicantion.model;

import java.util.List;
import java.util.Scanner;

public class Cliente extends Usuario {
    private List<Ingresso> ingressos;
    private List<Cupom> cupons;
    private List<Premio> premios;

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public List<Cupom> getCupons() {
        return cupons;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cupons = cupons;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }
}
