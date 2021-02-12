public class Cliente extends Usuario {
    private List<Ingresso> ingressos;
    private List<Cupom> cupons;
    private List<Premio> premios;

    public int inserirCliente();
    public int removerCliente();
    public int comprarIngresso();
    public int avaliar();
    public int utilizarCupom();
    public int compartilharCupom();
    public int resgatarPremio();
}