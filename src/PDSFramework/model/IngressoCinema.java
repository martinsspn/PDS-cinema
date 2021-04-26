package PDSFramework.model;

public class IngressoCinema extends Ingresso{
    private Filme filme;
    private int sala;

    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public int getSala() {
        return sala;
    }
    public void setSala(int sala) {
        this.sala = sala;
    }
}
