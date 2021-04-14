package PDSCinema.model;

public class Evento {
    private int avaliacoes;
    private String name;
    private int duracao;

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(int avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getQuantAvaliacoes() {
        return quantAvaliacoes;
    }

    public void setQuantAvaliacoes(int quantAvaliacoes) {
        this.quantAvaliacoes = quantAvaliacoes;
    }

    private int quantAvaliacoes;
}
